package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.HashRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HashServiceImpl implements HashService {

    @Autowired
    HashRepository hashRepository;

    @Override
    public String hashPassword(String password){
        return hashRepository.hashPassword(password);
    }

    @Override
    public boolean usernameExists(User user) {
        return hashRepository.usernameExists(user);
    }

    @Override
    public boolean passwordExists(User user){
        return hashRepository.passwordExists(user);
    }
}
