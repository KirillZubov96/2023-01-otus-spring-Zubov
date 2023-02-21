package ru.otus.quiz;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class QuizImplTest {

    @Test
    void readFile() {
        QuizImpl quiz = Mockito.mock(QuizImpl.class);
        quiz.readQuestionsFromFile();
    }
}
