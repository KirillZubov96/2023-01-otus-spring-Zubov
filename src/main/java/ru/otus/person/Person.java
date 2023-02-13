package ru.otus.person;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.otus.service.ConsoleIOService;

@Getter
@Component
public class Person {

    private String studentName;
    private String studentFirstName;
    private ConsoleIOService consoleIOService;

    public Person(ConsoleIOService consoleIOService) {
        this.consoleIOService = consoleIOService;
    }

    public void createStudentFromConsole() {
        consoleIOService.outputValue("Введите имя: ");
        this.studentName = consoleIOService.inputValue();
        consoleIOService.outputValue("Введите Фамилию: ");
        this.studentFirstName = consoleIOService.inputValue();
    }
}
