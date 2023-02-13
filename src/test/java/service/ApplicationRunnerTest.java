package service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.person.Person;
import ru.otus.quiz.QuizImpl;
import ru.otus.service.ApplicationRunner;
import ru.otus.service.ConsoleIOService;

public class ApplicationRunnerTest {

    @Test
    void runApp() {
        QuizImpl quiz = Mockito.mock(QuizImpl.class);
        Person person = Mockito.mock(Person.class);
        ConsoleIOService consoleIOService = Mockito.mock(ConsoleIOService.class);

        ApplicationRunner runner = new ApplicationRunner(quiz, person, consoleIOService);

        runner.run();
    }
}
