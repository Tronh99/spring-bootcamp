package com.solera.taskapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import com.solera.taskapi.model.Task;
import com.solera.taskapi.respository.TaskRepository;

@Service
public class TaskService {


    @Autowired
    private TaskRepository repository;


    public Task saveTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTask(){
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return repository.findById(id);
    }

 
    public void deletTaskById(Long id){
         repository.deleteById(id);
    }

    /*public Task updateTask(Long id){
        for (Task t : tasks) {
            if (id == t.getId()) {
                
                
            }
            
        }
         */

    }







}
