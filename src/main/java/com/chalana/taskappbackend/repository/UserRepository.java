package com.chalana.taskappbackend.repository;

import com.chalana.taskappbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
