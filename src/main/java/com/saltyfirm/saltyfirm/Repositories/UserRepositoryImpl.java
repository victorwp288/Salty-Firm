package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.DatabaseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    DatabaseHandler databaseHandler;

    public int createUser(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String privileges) {

        return 0;
    }

    public int editUser(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String privileges) {

        return 0;
    }

    public int deleteUser(int userId) {

        return 0;
    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();


        return usersList;
    }

    public int findUserById(int userId) {

        return 0;
    }

    public User checkLogin(String user) {

        return null;
    }
}
