package ru.otus.quiz;

import com.opencsv.CSVReader;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.otus.person.Student;
import ru.otus.question.Question;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
@PropertySource("application.properties")
public class QuizImpl implements Quiz {
    private String fileName;

    @Getter
    private int countOfCorrectAnswers;

    private int answersCorrectsNeededForPassed;

    public QuizImpl(@Value("${questionFileCsv}") String fileName, @Value("${correctAnswerCountForPassedTest}") String answersCorrectsNeededForPassed) {
        this.fileName = fileName;
        this.countOfCorrectAnswers = 0;
        this.answersCorrectsNeededForPassed = Integer.parseInt(answersCorrectsNeededForPassed);
    }

    public List<Question> readQuestionsFromFile() {
        List<Question> questions = new ArrayList<>();
        try {
            Resource resource = new ClassPathResource(fileName);

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

    public void checkCorrectAnswer(Question question, int answerNumber) {
        if (question.getCorrectAnswerNumber()==answerNumber) {
            countOfCorrectAnswers++;
        }
    }

    public boolean isQuizPassed() {
        return (countOfCorrectAnswers>=answersCorrectsNeededForPassed);
    }

}
