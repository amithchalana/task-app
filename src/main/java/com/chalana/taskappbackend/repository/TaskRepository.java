package com.chalana.taskappbackend.repository;

import com.chalana.taskappbackend.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
