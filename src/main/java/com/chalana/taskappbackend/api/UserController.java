package com.chalana.taskappbackend.api;

import com.chalana.taskappbackend.dto.UserDTO;
import com.chalana.taskappbackend.entity.User;
import com.chalana.taskappbackend.service.custom.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

//    private UserService userService ;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void createUserAccount(@Valid @RequestBody UserDTO user) {

//        userService.createNewUserAccount(user);
        System.out.println("successfully invoke");
        System.out.println(user);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping( value = "/me",consumes = "application/json")
    public void updateUserAccountDetails(@Valid @RequestBody UserDTO user ) {
        System.out.println("Invoke updateUserAccountDetails");
        System.out.println(user);
    }




    @GetMapping(value = "/me",produces = "application/json")
    public UserDTO getUserAccountDetails( @AuthenticationPrincipal(expression = "username") @RequestBody String username){
//        return userService.getUserAccountDetails(username);
        return null;
    }


    @DeleteMapping("/me")
    public void deleteUserAccount() {

    }
}
