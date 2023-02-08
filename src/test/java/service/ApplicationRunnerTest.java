package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.person.Student;
import ru.otus.quiz.QuizImpl;
import ru.otus.service.ApplicationRunner;

public class ApplicationRunnerTest {

    @Test
    void runApp() {
        QuizImpl quiz = Mockito.mock(QuizImpl.class);
        Student student = Mockito.mock(Student.class);

        ApplicationRunner runner = new ApplicationRunner(quiz, student);

        runner.run();
    }
}
