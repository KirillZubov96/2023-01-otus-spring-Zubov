package ru.otus.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.otus.person.Person;
import ru.otus.person.PersonDao;
import ru.otus.question.Question;
import ru.otus.quiz.QuizImpl;

import java.util.List;
import java.util.Locale;

@Service
public class ApplicationRunner {

    private final ConsoleIOService consoleIOService;
    private final QuizImpl quiz;
    private final PersonDao personDao;
    private List<Question> questions;

    private final Locale locale;

    public ApplicationRunner(QuizImpl quiz, PersonDao personDao, ConsoleIOService consoleIOService, @Value("${application.locale}") Locale locale) {
        this.quiz = quiz;
        this.personDao = personDao;
        this.consoleIOService = consoleIOService;
        this.locale = locale;
    }

    @PostConstruct
    private void run() {
        personDao.createStudentFromConsole();
        this.questions = quiz.readQuestionsFromFile();
        consoleIOService.outputValueByParam("welcome");
        for (int i = 0; i < questions.size(); i++) {
            consoleIOService.outputStringValue(consoleIOService.getParamFromProperty("question") + ": " + questions.get(i).getQuestion());
            consoleIOService.outputStringValue(consoleIOService.getParamFromProperty("answer") + " " + questions.get(i).getAnswers());
            consoleIOService.outputValueByParam("input.answer");
            Integer answerNumber = Integer.parseInt(consoleIOService.inputValue());
            quiz.checkCorrectAnswer(questions.get(i), answerNumber);
        }
        if (quiz.isQuizPassed()) {
            consoleIOService.outputValueByParam("passed.test");
        } else {
            consoleIOService.outputValueByParam("failed.test");
        }
    }
}
