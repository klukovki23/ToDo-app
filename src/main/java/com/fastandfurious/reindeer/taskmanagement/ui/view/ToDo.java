package com.fastandfurious.reindeer.taskmanagement.ui.view;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class ToDo {
    @Id
    @GeneratedValue
    private Long id; 
    private String task;
    private boolean done;

    public ToDo(String task) {
        this.task = task;
    }
    public ToDo() {

    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }

   
}
