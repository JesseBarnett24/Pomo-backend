package com.baziljesse.pomodoro.task;

import jakarta.persistence.*;

@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
            name="task_sequence",
            sequenceName = "task_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private String type;
    private Boolean status;
    private Integer total_time;
    private Integer current_time;

    public Task() {
    }

    public Task(Long id, String name, String description, String type, Boolean status, Integer total_time, Integer current_time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.status = status;
        this.total_time = total_time;
        this.current_time = current_time;
    }

    public Task(String name, String description, String type, Boolean status, Integer total_time, Integer current_time) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.status = status;
        this.total_time = total_time;
        this.current_time = current_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getTotal_time() {
        return total_time;
    }

    public void setTotal_time(Integer total_time) {
        this.total_time = total_time;
    }

    public Integer getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(Integer current_time) {
        this.current_time = current_time;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", total_time=" + total_time +
                ", current_time=" + current_time +
                '}';
    }
}
