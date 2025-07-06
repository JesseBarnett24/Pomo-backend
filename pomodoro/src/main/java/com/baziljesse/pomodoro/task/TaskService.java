package com.baziljesse.pomodoro.task;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskService {
    public List<Task> getTask(){
        return List.of(
                new Task(
                        1L,
                        "Jesse",
                        "Wow Jesse Cool",
                        "Coding",
                        true,
                        50,
                        30
                )
        );
    }

}
