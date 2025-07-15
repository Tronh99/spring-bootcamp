package com.solera.taskapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.solera.taskapi.model.Task;
import com.solera.taskapi.service.TaskService;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private  TaskService taskService;


    @GetMapping
    public ResponseEntity<List<Task>> getTaksList() {
        List<Task> task = taskService.getAllTask();
        return ResponseEntity.ok(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id).map(
            ResponseEntity::ok).
            orElse(ResponseEntity.noContent().build());
    }
    
    

    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task saveTask = taskService.saveTask(task);
        if (saveTask == null) {
            return ResponseEntity.internalServerError().body(null);
        }
        return ResponseEntity.ok(saveTask);

    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        taskService.deletTaskById(id);
    }
    
    // @PatchMapping("/{id}")


}
