package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.question.Question;
import ru.otus.service.CsvParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("/spring-context.xml")
                .getBean(CsvParser.class)
                .readQuestionsFromFile().stream()
                .forEach(question -> System.out.println(question.toString()));
    }
}