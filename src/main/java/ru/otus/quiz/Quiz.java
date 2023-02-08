package ru.otus.quiz;

import org.springframework.beans.factory.annotation.Value;
import ru.otus.question.Question;

import java.util.List;

public interface Quiz {

    List<Question> readQuestionsFromFile();

}
