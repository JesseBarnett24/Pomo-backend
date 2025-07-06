package com.baziljesse.pomodoro.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository){
        return args -> {
            Task codespring = new Task(
                    "Code Java Spring",
                    "Wow Jesse Cool, you are coding Java Spring!",
                    "Coding",
                    true,
                    50
            );
            Task drinkwater = new Task(
                    "Drink Water",
                    "Lame but required water drinking",
                    "Health",
                    true,
                    5
            );

            repository.saveAll(
                    List.of(codespring, drinkwater)
            );
        };
    }
}
