package com.baziljesse.pomodoro.task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {
    private static final int NAME_MAX_LENGTH = 20;
    private static final int DESCRIPTION_MAX_LENGTH = 100;
    private static final int TYPE_MAX_LENGTH = 20;
    private static final int TIME_MAX_LENGTH = 100000;


    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTask(){
        return taskRepository.findAll();
    }

    public void addNewTask(Task task) {
        Optional<Task> taskOptional = taskRepository.findTaskByName(task.getName());
        if(taskOptional.isPresent()) {
            throw new IllegalStateException("Task name already exists");
        }
        taskRepository.save(task);
    }

    @Transactional
    public void updateTask(Long taskId, String name, String description, String type, Integer total_time) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalStateException("Task not found"));
        if (name != null && !name.isEmpty() && name.length() < NAME_MAX_LENGTH && !Objects.equals(name, task.getName())) {
            task.setName(name);
        }
        if (description != null && description.length() < DESCRIPTION_MAX_LENGTH) {
            task.setDescription(description);
        }
        if (type != null && !type.isEmpty() && type.length() < TYPE_MAX_LENGTH) {
            task.setType(type);
        }
        if (total_time != null && total_time > 0 && total_time < TIME_MAX_LENGTH) {
            task.setTotal_time(total_time);
        }
    }

    public void deleteTask(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if (!exists) {
            throw new IllegalStateException("Task does not exist");
        }
        taskRepository.deleteById(taskId);
    }
}
