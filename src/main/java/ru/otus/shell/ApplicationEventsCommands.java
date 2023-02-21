package ru.otus.shell;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.service.ApplicationRunnerImpl;

@ShellComponent
@AllArgsConstructor
public class ApplicationEventsCommands {

    private ApplicationRunnerImpl runner;
    @ShellMethod(value = "Start testing", key = {"start"})
    public void start() {
        runner.run();
    }

    @ShellMethod(value = "Stop Application", key = {"stop"})
    private void stop(){
        System.exit(0);
    }
}
