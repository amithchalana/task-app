package lk.ijse.dep9.app.service.custom.impl;

import lk.ijse.dep9.app.dto.UserDTO;
import lk.ijse.dep9.app.service.custom.UserService;

import lk.ijse.dep9.app.util.Transformer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional // point cut for transaction and connection management
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;


    private final Transformer transformer;

    public UserServiceImpl(UserDAO userDAO, Transformer transformer) {
        this.userDAO = userDAO;
        this.transformer = transformer;
    }


    @Override
    public void createNewUserAccount(UserDTO userDTO) {


    }
}
