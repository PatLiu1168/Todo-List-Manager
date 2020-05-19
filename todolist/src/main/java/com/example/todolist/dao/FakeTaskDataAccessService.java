package com.example.todolist.dao;

import com.example.todolist.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fakeDao") //differentiates - multiple implementations of Dao
public class FakeTaskDataAccessService implements TaskDao{
    private static List<Task> DB = new ArrayList<>();

    //Override
    public int insertTask(Task task){
        DB.add(new Task(task.getDay(), task.getName(), task.getTask()));
        return 1;
    }

}
