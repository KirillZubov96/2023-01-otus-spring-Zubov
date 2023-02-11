package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.person.PersonDao;
import ru.otus.quiz.QuizImpl;
import ru.otus.service.ApplicationRunner;

public class ApplicationRunnerTest {

    @Test
    void runApp() {
        QuizImpl quiz = Mockito.mock(QuizImpl.class);
        PersonDao personDao = Mockito.mock(PersonDao.class);

        ApplicationRunner runner = new ApplicationRunner(quiz, personDao);

        runner.run();
    }
}
