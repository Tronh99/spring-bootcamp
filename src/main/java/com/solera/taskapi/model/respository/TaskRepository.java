package com.solera.taskapi.model.respository;

import com.solera.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Additional query methods can be defined here if needed

}
