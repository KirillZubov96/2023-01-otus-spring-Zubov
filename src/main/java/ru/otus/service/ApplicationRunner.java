package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.person.PersonDao;
import ru.otus.question.Question;
import ru.otus.quiz.QuizImpl;

import java.util.List;

@Service
public class ApplicationRunner {

    private PersonDao personDao;
    private List<Question> questions;
    private final ConsoleIOService consoleIOService;

    private final QuizImpl quiz;

    public ApplicationRunner(QuizImpl quiz, PersonDao personDao) {
        this.quiz = quiz;
        this.personDao = personDao;
        consoleIOService = new ConsoleIOService();
    }

    public void run() {
        personDao = personDao.createStudentFromConsole();
        this.questions = quiz.readQuestionsFromFile();
        consoleIOService.outputValue("Welcome to test, " + personDao.getStudentName() + " " + personDao.getStudentFirstName() + "!");
        for (int i = 0; i < questions.size(); i++) {
            consoleIOService.outputValue("Question №" + (i + 1) + ": " + questions.get(i).getQuestion());
            consoleIOService.outputValue("Answers: " + questions.get(i).getAnswers());
            consoleIOService.outputValue("Input your answer number: ");
            Integer answerNumber = Integer.parseInt(consoleIOService.inputValue());
            quiz.checkCorrectAnswer(questions.get(i), answerNumber);
        }
        if (quiz.isQuizPassed()) {
            consoleIOService.outputValue("Test passed!");
        } else {
            consoleIOService.outputValue("Test failed!");
        }
    }
}
