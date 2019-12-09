package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.User;

import java.util.Date;
import java.util.List;

public interface UserRepository {

    int createUser(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String privileges);
    int editUser(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String privileges);
    int deleteUser(int userId);
    List<User> getAllUsers();
    User findUserById(int userId);
    User checkLogin(String username, String password);

}
