package com.saltyfirm.saltyfirm;

import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.*;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.Hashing;

public class Test {
    public static void main(String[] args) {

        UserRepositoryImpl ur = new UserRepositoryImpl();
        User user = new User("Frækfyr","1234", "Peter", "Sørensen", 76859485, "m", "01-02-1985","Leder","frækfyr@hotmail.com","Danmark","1");
        //ur.createUser(user);
        //System.out.println(user.getBirthdate());
        // System.out.println(user.getPrivileges());
        //System.out.println(ur.getAllUsers().toString());
        // User user1 = ur.findUserById(3);
        // user1.setFirstname("TESTER");
        // ur.editUser(user1);
        // System.out.println(ur.getAllUsers().toString());

         DepartmentRepositoryImpl dr = new DepartmentRepositoryImpl();

        // List<Department> departmentList = dr.getDepartments(2);
        // System.out.println(departmentList.toString());
        // dr.updateDepartmentScore(2);
        // System.out.println(dr.getDepartmentScores(2));
        // dr.deleteDepartment(1);
        // List<Department> departmentList1 = dr.getDepartments(1);
        // System.out.println("Pension = "+dr.getDepartmentScores(1).get(0));
        // System.out.println("Benefits = "+dr.getDepartmentScores(1).get(1));
        // System.out.println("Management = "+dr.getDepartmentScores(1).get(2));
        // System.out.println("Environment = "+dr.getDepartmentScores(1).get(3));
        // System.out.println("Flexibility = "+dr.getDepartmentScores(1).get(4));
        // System.out.println("Total Score = "+dr.getDepartmentScores(1).get(5));
        // System.out.println(dr.findDepartmentById(2).toString());

        // FirmRepositoryImpl f = new FirmRepositoryImpl();
        // System.out.println(f.searchFirms("alle").toString());

        HashRepositoryImpl a = new HashRepositoryImpl();
        System.out.println(a.hashPassword("mypassword"));
        //System.out.println(a.passwordExists(user));
        //System.out.println(a.usernameExists(user));



         //UserRepositoryImpl urr = new UserRepositoryImpl();
        //System.out.println(urr.getAllUsers().toString());

       // ReviewRepositoryImpl rr = new ReviewRepositoryImpl();
        // Review review = new Review("Dette er en test for oprettelse af review", 6, "Tjener", 4, 5, 6, 7, 8, 9 )
          //      rr.createReview(new Review("Dette er en test for oprettelse af review", 6, "Tjener", 4, 5, 6, 7, 8, 9 ), 1, 3);
        //System.out.println(rr.fetchUserReview(2));


    }
}
