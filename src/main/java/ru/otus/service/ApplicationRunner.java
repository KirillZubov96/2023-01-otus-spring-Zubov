package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.person.Person;
import ru.otus.question.Question;
import ru.otus.quiz.QuizImpl;

import java.util.List;

@Service
public class ApplicationRunner {

    private final ConsoleIOService consoleIOService;
    private final QuizImpl quiz;
    private final Person person;
    private List<Question> questions;

    public ApplicationRunner(QuizImpl quiz, Person person, ConsoleIOService consoleIOService) {
        this.quiz = quiz;
        this.person = person;
        this.consoleIOService = consoleIOService;
        run();
    }

    private void run() {
        person.createStudentFromConsole();
        this.questions = quiz.readQuestionsFromFile();
        consoleIOService.outputValue("Welcome to test, " + person.getStudentName() + " " + person.getStudentFirstName() + "!");
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
