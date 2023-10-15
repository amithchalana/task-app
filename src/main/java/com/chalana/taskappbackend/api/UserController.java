package com.chalana.taskappbackend.api;

import com.chalana.taskappbackend.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService ;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUserAccount(@RequestBody UserDTO user) {
        userService.createNewUserAccount(user);
    }
}
