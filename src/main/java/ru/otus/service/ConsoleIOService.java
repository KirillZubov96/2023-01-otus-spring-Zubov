package ru.otus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;
@Service
public class ConsoleIOService {

    private final Locale locale;
    private final Scanner sc;
    private final MessageSource messageSource;

    public ConsoleIOService(@Value("${application.locale}") Locale locale, MessageSource messageSource) {
        sc = new Scanner(System.in);
        this.locale = locale;
        this.messageSource = messageSource;
    }

    public String inputValue() {
        return sc.nextLine();
    }

    public void outputValueByParam(String param) {
        outputStringValue(getParamFromProperty(param));
    }

    public void outputStringValue(String value) {
        System.out.println(new String(value.getBytes(), StandardCharsets.UTF_8));
    }

    public String getParamFromProperty(String param) {
        return (messageSource.getMessage(param, new Object[] {}, locale));
    }
}
