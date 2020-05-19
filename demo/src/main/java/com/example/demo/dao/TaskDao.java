package com.example.demo.dao;

import com.example.demo.model.Task;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TaskDao {

    int insertTask(Task task);

    Optional<Task> selectTask (String taskName);

    int deleteTask (String taskName);

    //int updateTask (String taskName);

    public List<Task> selectAllTasks();

}
