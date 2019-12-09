package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.User;

import java.util.Date;
import java.util.List;

public interface UserRepository {

    int createUser(User user);
    int editUser(User user);
    int deleteUser(int userId);
    List<User> getAllUsers();
    User findUserById(int userId);
    User checkLogin(String username, String password);

}
