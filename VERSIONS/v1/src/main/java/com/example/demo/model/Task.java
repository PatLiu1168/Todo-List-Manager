package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Task {
    private final String name;

    private final Date day;

    @NotBlank
    private final String task;

    public Task(@JsonProperty("day") Date day, @JsonProperty("name") String name, @JsonProperty("task")String task) {
        this.day = day;
        this.task = task;
        this.name = name;
    }

    public Date getDay(){ return day; }
    public String getTask(){
        return task;
    }
    public String getName() {return name;}

//    public void setName(String name){
//        this.name = name;
//    }

}
