package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.User;

public interface HashRepository {

    String hashPassword(String password);
    boolean usernameExists(User user);
    boolean passwordExists(User user);

}
