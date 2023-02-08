package ru.otus.person;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.Scanner;

@Getter
@Repository
public class Student {

    private String studentName;
    private String studentFirstName;

    public Student() {
        createStudentFromConsole();
    }

    public Student(String name, String firstName) {
        this.studentName = name;
        this.studentFirstName = firstName;
    }

    private Student createStudentFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        studentName = in.nextLine();
        System.out.print("Введите Фамилию: ");
        studentFirstName = in.nextLine();
        return new Student(studentName, studentFirstName);
    }
}
