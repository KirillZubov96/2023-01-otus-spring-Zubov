package quiz;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.quiz.QuizImpl;


public class QuizImplTest {

    @Test
    void readFile() {
        QuizImpl quiz = Mockito.mock(QuizImpl.class);
        quiz.readQuestionsFromFile();
    }
}
