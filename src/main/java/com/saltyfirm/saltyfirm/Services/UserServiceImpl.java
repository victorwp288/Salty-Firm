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

    public int createUser(User user) {
        return userRepository.createUser(user);
    }

    @Override
    public int editUser(User user) {
        return userRepository.editUser(user);
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
