package com.solera.taskapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.solera.taskapi.model.Task;
import com.solera.taskapi.service.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task saveTask = taskService.saveTask(task);
        if (saveTask == null) {
            return ResponseEntity.internalServerError().body(null);
        }
        return ResponseEntity.ok(saveTask);

    }

}
