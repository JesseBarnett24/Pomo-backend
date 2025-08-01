package com.baziljesse.pomodoro.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT s FROM Task s WHERE s.name = ?1")
    Optional<Task> findTaskByName(String name);
}
