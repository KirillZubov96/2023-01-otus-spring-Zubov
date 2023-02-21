package ru.otus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.person.PersonDao;
import ru.otus.question.Question;
import ru.otus.quiz.QuizImpl;

import java.util.List;
import java.util.Locale;

@Service
public class ApplicationRunnerImpl implements ApplicationRunner {

    private final ConsoleIOService consoleIOService;
    private final QuizImpl quiz;
    private final PersonDao personDao;
    private final Locale locale;
    private List<Question> questions;

    public ApplicationRunnerImpl(QuizImpl quiz, PersonDao personDao, ConsoleIOService consoleIOService, @Value("${application.locale}") Locale locale) {
        this.quiz = quiz;
        this.personDao = personDao;
        this.consoleIOService = consoleIOService;
        this.locale = locale;
    }

    @Override
    public void run() {
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
