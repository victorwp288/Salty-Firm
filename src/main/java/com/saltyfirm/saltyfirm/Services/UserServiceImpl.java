package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public int createUser(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String privileges) {
        return 0;
    }

    @Override
    public int editUser(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String privileges) {
        return userRepository.editUser(userId, username, password, firstname, lastname, phoneNumber, gender, birthdate, education, mail, nationality,privileges);
    }

    @Override
    public int deleteUser(int userId) {
        return userRepository.deleteUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User findUserById(int userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public User checkLogin(String username, String password) {
        return userRepository.checkLogin(username, password);
    }
}
