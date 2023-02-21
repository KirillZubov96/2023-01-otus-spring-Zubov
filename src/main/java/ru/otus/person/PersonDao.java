package ru.otus.person;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.service.ConsoleIOService;

@AllArgsConstructor
@Service
public class PersonDao {
    private Person person;

    private ConsoleIOService consoleIOService;

    public void createStudentFromConsole() {
        consoleIOService.outputValueByParam("name.input");
        person.setStudentName(consoleIOService.inputValue());
        consoleIOService.outputValueByParam("firstname.input");
        person.setStudentFirstName(consoleIOService.inputValue());
    }
}
