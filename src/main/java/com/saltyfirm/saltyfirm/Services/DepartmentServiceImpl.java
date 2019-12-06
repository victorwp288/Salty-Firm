package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired


    @Override
    public int findDepartmentById(int departmentId) {
        return 0;
    }

    @Override
    public List<Department> getDepartments(int firmId) {
        return null;
    }

    @Override
    public int deleteDepartment(int departmentId) {
        return 0;
    }

    @Override
    public int editDepartment(int departmentId, String departmentName, String departmentAdress, double departmentScore) {
        return 0;
    }

    @Override
    public double calculateDepartmentScore(int departmentId) {
        return 0;
    }
}
