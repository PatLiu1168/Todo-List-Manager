package com.example.demo.dao;

import com.example.demo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskDao {

    int insertTask(Task task);

    Optional<Task> selectTask (String taskName);

    int deleteTask (String taskName);

    int updateTask (Task task);

    public List<Task> selectAllTasks();

}
