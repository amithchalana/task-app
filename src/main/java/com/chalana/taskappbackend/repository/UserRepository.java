package com.chalana.taskappbackend.repository;

import com.chalana.taskappbackend.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
}
