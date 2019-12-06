package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentRepositoryImpl implements DepartmentRepository {


    public int findDepartmentById(int departmentId) {

        return 0;
    }

    public List<Department> getDepartments(int firmId) {
        List<Department> departmentsList = new ArrayList<>();

        return departmentsList;
    }

    public int deleteDepartment(int departmentId) {

        return 0;
    }

    public int editDepartment(int departmentId, String departmentName, String departmentAdress, double departmentScore) {

        return 0;
    }

    public double calculateDepartmentScore(int departmentId) {

        return 0;
    }

}
