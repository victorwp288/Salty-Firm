package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.User;

public interface HashService {

    String hashPassword(String password);
    boolean usernameExists(User user);
    boolean passwordExists(User user);

}
