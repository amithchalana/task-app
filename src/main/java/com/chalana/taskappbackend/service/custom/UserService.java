package com.chalana.taskappbackend.service.custom;

import com.chalana.taskappbackend.dto.UserDTO;
import com.chalana.taskappbackend.service.SuperService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends SuperService, UserDetailsService {
    void createNewUserAccount(UserDTO userDTO);

    UserDTO getUserAccountDetails(String username);

    UserDTO GetUserAccountDetails(String username);

    void updateUserAccountDetails(UserDTO userDTO);
    void deleteUserAccount(String username);
}
