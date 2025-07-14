package com.solera.taskapi.service;

import org.springframework.stereotype.Service;
import com.solera.taskapi.model.Task;
import com.solera.taskapi.model.respository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }


}
