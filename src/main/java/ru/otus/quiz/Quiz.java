package ru.otus.quiz;

import ru.otus.question.Question;

import java.util.List;

public interface Quiz {

    List<Question> readQuestionsFromFile();

}
