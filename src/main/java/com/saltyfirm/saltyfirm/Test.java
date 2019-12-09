package com.saltyfirm.saltyfirm;

import com.saltyfirm.saltyfirm.Repositories.UserRepositoryImpl;

public class Test {
    public static void main(String[] args) {

        UserRepositoryImpl ur = new UserRepositoryImpl();

        System.out.println(ur.getAllUsers().toString());
    }
}
