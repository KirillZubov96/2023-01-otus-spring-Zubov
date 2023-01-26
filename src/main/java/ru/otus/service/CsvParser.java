package ru.otus.service;

import com.opencsv.CSVReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.question.Question;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser {

    private String fileName;

    public CsvParser(String fileName) {
        this.fileName = fileName;
    }

    public List<Question> readQuestionsFromFile() {
        List<Question> questions = new ArrayList<>();
        try {
            Resource resource = new ClassPathResource(fileName);

            try (CSVReader csvReader = new CSVReader(new FileReader(resource.getURI().getPath()), ';')) {
                List<String[]> questionsAndAnswers = csvReader.readAll();

                for (String[] line : questionsAndAnswers) {
                    Question q = new Question(line[0], Arrays.asList(line).subList(2, line.length - 1), line.length);
                    questions.add(q);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
