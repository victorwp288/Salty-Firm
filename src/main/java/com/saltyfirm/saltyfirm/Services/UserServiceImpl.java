package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {



    @Override
    public int editUser(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String priviliges) {
        return 0;
    }

    @Override
    public int deleteUser(int userId) {
        return 0;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public int findUserById(int userId) {
        return 0;
    }

    @Override
    public User checkLogin(String user) {
        return null;
    }
}
