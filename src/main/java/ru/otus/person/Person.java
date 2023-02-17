package ru.otus.person;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.otus.service.ConsoleIOService;

@Getter
@Setter
@Component
public class Person {

    private String studentName;
    private String studentFirstName;

}
