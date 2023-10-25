package com.chalana.taskappbackend.repository;

import com.chalana.taskappbackend.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
