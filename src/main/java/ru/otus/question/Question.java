package ru.otus.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Question {

    private String question;

    private List<String> answers;

    private int correctAnswerNumber;
}
