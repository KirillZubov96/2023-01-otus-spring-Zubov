package ru.otus.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Question {

    private String question;

    private List<String> answers;

    private int correctAnswerNumber;


    @Override
    public String toString() {
        return ("Вопрос: " + question + "; Варианты ответов: " + answers + "; Номер правильного ответа: " + correctAnswerNumber);
    }
}
