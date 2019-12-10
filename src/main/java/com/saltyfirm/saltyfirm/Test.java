package com.saltyfirm.saltyfirm;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.DepartmentRepository;
import com.saltyfirm.saltyfirm.Repositories.DepartmentRepositoryImpl;
import com.saltyfirm.saltyfirm.Repositories.FirmRepositoryImpl;
import com.saltyfirm.saltyfirm.Repositories.UserRepositoryImpl;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        // UserRepositoryImpl ur = new UserRepositoryImpl();
        // User user = new User("Frækfyr","1234", "Peter", "Sørensen", 76859485, "m", new Date(1985-01-02),"Leder","frækfyr@hotmail.com","Danmark","1");
        // ur.createUser(user);
        // System.out.println(ur.getAllUsers().toString());
        // User user1 = ur.findUserById(3);
        // user1.setFirstname("TESTER");
        // ur.editUser(user1);
        // System.out.println(ur.getAllUsers().toString());

        DepartmentRepositoryImpl dr = new DepartmentRepositoryImpl();
        // List<Department> departmentList = dr.getDepartments(1);
        // System.out.println(departmentList.toString());
        // dr.deleteDepartment(1);
        // List<Department> departmentList1 = dr.getDepartments(1);
        // System.out.println("Pension = "+dr.calculateDepartmentScore(1).get(0));
        // System.out.println("Benefits = "+dr.calculateDepartmentScore(1).get(1));
        // System.out.println("Management = "+dr.calculateDepartmentScore(1).get(2));
        // System.out.println("Environment = "+dr.calculateDepartmentScore(1).get(3));
        // System.out.println("Flexibility = "+dr.calculateDepartmentScore(1).get(4));
        // System.out.println("Total Score = "+dr.calculateDepartmentScore(1).get(5));
        // System.out.println(dr.findDepartmentById(4).toString());

        // FirmRepositoryImpl f = new FirmRepositoryImpl();
        // System.out.println(f.searchFirms("alle").toString());
    }
}
