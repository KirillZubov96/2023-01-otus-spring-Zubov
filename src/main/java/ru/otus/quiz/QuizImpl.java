package ru.otus.quiz;

import com.opencsv.CSVReader;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.otus.question.Question;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class QuizImpl implements Quiz {
    private final String fileName;
    private final int answersCorrectsNeededForPassed;
    @Getter
    private int countOfCorrectAnswers;

    private final Locale locale;

    public QuizImpl(@Value("${application.questionFileCsv}") String fileName, @Value("${application.correctAnswerCountForPassedTest}") String answersCorrectsNeededForPassed, @Value("${application.locale}") Locale locale) {
        this.fileName = fileName;
        this.countOfCorrectAnswers = 0;
        this.answersCorrectsNeededForPassed = Integer.parseInt(answersCorrectsNeededForPassed);
        this.locale = locale;
    }

    public List<Question> readQuestionsFromFile() {
        List<Question> questions = new ArrayList<>();
        try {
            Resource resource = new ClassPathResource(String.format(fileName, locale));

            try (CSVReader csvReader = new CSVReader(new FileReader(resource.getURI().getPath()), ';')) {
                List<String[]> questionsAndAnswers = csvReader.readAll();

                for (String[] line : questionsAndAnswers) {
                    Question q = new Question(line[0], Arrays.asList(line).subList(1, line.length - 1), Integer.valueOf(line[line.length - 1]));
                    questions.add(q);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    @Override
    public void checkCorrectAnswer(Question question, int answerNumber) {
        if (question.getCorrectAnswerNumber() == answerNumber) {
            countOfCorrectAnswers++;
        }
    }

    @Override
    public boolean isQuizPassed() {
        return (countOfCorrectAnswers >= answersCorrectsNeededForPassed);
    }

}
