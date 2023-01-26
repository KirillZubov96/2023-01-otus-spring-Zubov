package ru.otus;

import ru.otus.question.Question;
import ru.otus.service.CsvParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvParser parser = new CsvParser("questions.csv");
        List<Question> questions = parser.readQuestionsFromFile();
        System.out.println(questions.get(0).getQuestion());
        System.out.println(questions.get(0).getAnswers());
        System.out.println(questions.get(0).getAnswerNumber());
        //осталось обвязку в спирнг, сделать toString для красивого вывода
    }
}