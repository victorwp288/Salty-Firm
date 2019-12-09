package com.saltyfirm.saltyfirm;

import com.saltyfirm.saltyfirm.Repositories.FirmRepositoryImpl;

public class Test {
    public static void main(String[] args) {

        FirmRepositoryImpl firm = new FirmRepositoryImpl();

        System.out.println(firm.findFirmById(2).toString());
    }
}
