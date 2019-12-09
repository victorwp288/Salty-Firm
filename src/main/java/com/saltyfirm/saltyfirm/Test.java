package com.saltyfirm.saltyfirm;

import com.saltyfirm.saltyfirm.Repositories.FirmRepositoryImpl;

public class Test {
    public static void main(String[] args) {

        //UserRepositoryImpl ur = new UserRepositoryImpl();

        //System.out.println(ur.getAllUsers().toString());

        FirmRepositoryImpl f = new FirmRepositoryImpl();
        System.out.println(f.searchFirms("Dalle Valle").toString());
    }
}
