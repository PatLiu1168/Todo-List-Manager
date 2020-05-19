package com.example.demo.api;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/list")
@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public void addTask(@Valid @NonNull @RequestBody Task task){
        //take request body and put it in this person
        taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping(path = "{taskName}")
    public Task getTask(@PathVariable("taskName") String taskName){
        return taskService.getTask(taskName).orElse(null); //can be a custom message or exception
    }

    @DeleteMapping(path = "{taskName}")
    public void deleteTask (@PathVariable("taskName") String taskName){
        taskService.removeTask(taskName);
    }
//
//    @PutMapping(path = "{taskName}")
//    public void updateTask(@PathVariable("taskName") String taskName){
//        taskService.updateTask(String taskName);
//    }
}
