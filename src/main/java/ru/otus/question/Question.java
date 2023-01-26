package ru.otus.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
public class Question {
    @Getter
    @Setter
    private String question;
    @Getter
    @Setter
    private List<String> answers;
    @Getter
    @Setter
    private int answerNumber;
}
