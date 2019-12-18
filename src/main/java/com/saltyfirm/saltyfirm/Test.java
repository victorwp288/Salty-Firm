package com.saltyfirm.saltyfirm;


import com.saltyfirm.saltyfirm.Repositories.FirmRepositoryImpl;
import com.saltyfirm.saltyfirm.Repositories.HashRepositoryImpl;

public class Test {
    public static void main(String[] args) {

        HashRepositoryImpl hash = new HashRepositoryImpl();
        System.out.println(hash.hashPassword("test4"));

        FirmRepositoryImpl firmRepository = new FirmRepositoryImpl();
        System.out.println(firmRepository.searchFirms("føtex"));

    }
}
