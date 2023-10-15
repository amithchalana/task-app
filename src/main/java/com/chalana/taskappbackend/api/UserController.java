package com.chalana.taskappbackend.api;


import com.chalana.taskappbackend.entity.User;
import com.chalana.taskappbackend.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(produces = "application/json")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
