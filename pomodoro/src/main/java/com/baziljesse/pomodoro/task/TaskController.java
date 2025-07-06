package com.baziljesse.pomodoro.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTask() {
        return taskService.getTask();
    }

    @PostMapping
    public void registerNewTask(@RequestBody Task task) {
        taskService.addNewTask(task);

    }

    @PutMapping(path = {"{taskId}"})
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer total_time){
        taskService.updateTask(taskId, name, description, type, total_time);
    }



            @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId){
        taskService.deleteTask(taskId);
    }
}
