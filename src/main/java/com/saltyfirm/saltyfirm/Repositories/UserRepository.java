package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.User;

import java.util.Date;
import java.util.List;

public interface UserRepository {

    int editUser(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String priviliges);
    int deleteUser(int userId);
    List<User> getAllUsers();
    int findUserById(int userId);
    User checkLogin(String user);

}
