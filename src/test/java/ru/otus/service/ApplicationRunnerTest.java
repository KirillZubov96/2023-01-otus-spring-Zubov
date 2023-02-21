package ru.otus.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.person.Person;
import ru.otus.person.PersonDao;
import ru.otus.quiz.QuizImpl;

import java.util.Locale;

public class ApplicationRunnerTest {

    @Test
    void runApp() {
        QuizImpl quiz = Mockito.mock(QuizImpl.class);
        PersonDao personDao = Mockito.mock(PersonDao.class);
        ConsoleIOService consoleIOService = Mockito.mock(ConsoleIOService.class);
        Locale locale = Locale.getDefault();

        new ApplicationRunner(quiz, personDao, consoleIOService, locale);
    }
}
