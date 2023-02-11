package ru.otus.person;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.service.ConsoleIOService;

@Getter
@Component
public class PersonDao {

    private String studentName;
    private String studentFirstName;
    private ConsoleIOService consoleIOService;

    @Autowired
    public PersonDao() {
    }

    public PersonDao(String name, String firstName) {
        this.studentName = name;
        this.studentFirstName = firstName;
    }

    public PersonDao createStudentFromConsole() {
        consoleIOService = new ConsoleIOService();
        consoleIOService.outputValue("Введите имя: ");
        studentName = consoleIOService.inputValue();
        consoleIOService.outputValue("Введите Фамилию: ");
        studentFirstName = consoleIOService.inputValue();
        return new PersonDao(studentName, studentFirstName);
    }
}
