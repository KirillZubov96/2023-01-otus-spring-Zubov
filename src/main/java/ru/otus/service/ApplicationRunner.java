package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.otus.person.Student;
import ru.otus.question.Question;
import ru.otus.quiz.QuizImpl;

import java.util.List;

@Service
@PropertySource("application.properties")
public class ApplicationRunner {

    private final Student student;
    private final List<Question> questions;
    private final ConsoleIOService consoleIOService;

    private final QuizImpl quiz;

    @Autowired
    public ApplicationRunner(QuizImpl quiz, Student student) {
        this.quiz = quiz;
        this.student = student;
        questions = quiz.readQuestionsFromFile();
        consoleIOService = new ConsoleIOService();
    }

    public void run() {
        System.out.println("Welcome to test, " + student.getStudentName() + " " + student.getStudentFirstName() + "!");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question №" + (i + 1) + ": " + questions.get(i).getQuestion());
            System.out.println("Answers: " + questions.get(i).getAnswers());
            System.out.print("Input your answer number: ");
            Integer answerNumber = Integer.parseInt(consoleIOService.inputValue());
            quiz.checkCorrectAnswer(questions.get(i), answerNumber);
        }
        if (quiz.isQuizPassed()) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }
}
