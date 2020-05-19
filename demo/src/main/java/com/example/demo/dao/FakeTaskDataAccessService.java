package com.example.demo.dao;

import com.example.demo.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDao") //differentiates - multiple implementations of Dao
public class FakeTaskDataAccessService implements TaskDao{
    private static List<Task> DB = new ArrayList<>();

    @Override
    public int insertTask(Task task){
        DB.add(new Task(task.getDay(), task.getName(), task.getTask()));
        return 1;
    }

    @Override
    public Optional<Task> selectTask(String taskName) {
        //make more specific later
        String name=taskName;
        return DB.stream().filter(task -> task.getTask().equals(name)).findFirst();
    }

    @Override
    public int deleteTask(String taskName) {
        //make more specific later
        Optional<Task> flag = selectTask(taskName);
        if (flag.isEmpty()){
            return 0;
        }

        DB.remove(flag.get());
        return 1;
    }

//    @Override
//    public int updateTask(String taskName) {
//        return selectTask(taskName).map(task -> {int indexofTask = DB.indexOf(task);
//            if (indexofTask >=0){
//                //found
//                DB.set(indexofTask, new Task(id, update.getName()));
//                return 1;
//            }
//
//            return 0;
//        }).orElse(0);
//    }

    @Override
    public List<Task> selectAllTasks() {
        return DB;
    }

}
