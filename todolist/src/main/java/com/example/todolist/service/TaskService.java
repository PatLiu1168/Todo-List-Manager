package com.example.todolist.service;

import com.example.todolist.dao.TaskDao;
import com.example.todolist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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


}
