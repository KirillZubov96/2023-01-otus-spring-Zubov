package ru.otus.person;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.otus.service.ConsoleIOService;

import java.util.Scanner;

@Getter
@Repository
public class Student {

    private String studentName;
    private String studentFirstName;

    private ConsoleIOService consoleIOService;

    public Student() {
        this.consoleIOService = new ConsoleIOService();
        createStudentFromConsole();
    }

    public Student(String name, String firstName) {
        this.studentName = name;
        this.studentFirstName = firstName;
    }

    private Student createStudentFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        studentName = consoleIOService.inputValue();
        System.out.print("Введите Фамилию: ");
        studentFirstName = consoleIOService.inputValue();
        return new Student(studentName, studentFirstName);
    }
}
