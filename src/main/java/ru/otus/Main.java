package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.question.Question;
import ru.otus.service.CsvParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        CsvParser parser = context.getBean(CsvParser.class);
        List<Question> questions = parser.readQuestionsFromFile();
        questions.stream().forEach(question -> System.out.println(question.toString()));
    }
}