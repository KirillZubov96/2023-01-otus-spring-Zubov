package ru.otus.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class ConsoleIOService {
    private final Scanner sc;

    public ConsoleIOService() {
        sc = new Scanner(System.in);
    }

    public String inputValue() {
        return sc.nextLine();
    }

    public void outputValue(String value) {
        System.out.println(value);
    }
}
