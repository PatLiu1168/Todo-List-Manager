package com.example.demo.service;

import com.example.demo.dao.TaskDao;
import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskDao taskDao;

    @Autowired
    //change to postgres later
    public TaskService(@Qualifier("fakeDao")TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public int addTask(Task task){
        return taskDao.insertTask(task);
    }


    public List<Task> getAllTasks() {
        return taskDao.selectAllTasks();
    }

    public Optional<Task> getTask(String taskName) {
        return taskDao.selectTask(taskName);
    }

    public int removeTask(String taskName) {
        return taskDao.deleteTask(taskName);
    }

//    public int updateTask (String taskName){
//        return taskDao.updateTask(taskName);
//    }
}
