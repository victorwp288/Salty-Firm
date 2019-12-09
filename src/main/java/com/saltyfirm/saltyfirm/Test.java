package com.saltyfirm.saltyfirm;

import com.saltyfirm.saltyfirm.Repositories.FirmRepositoryImpl;

public class Test {
    public static void main(String[] args) {

        FirmRepositoryImpl i = new FirmRepositoryImpl();

        i.findFirmById(1);

    }
}
