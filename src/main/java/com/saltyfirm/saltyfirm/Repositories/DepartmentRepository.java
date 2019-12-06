package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Department;

import java.util.List;

public interface DepartmentRepository {

    int findDepartmentById(int departmentId);
    List<Department> getDepartments(int firmId);
    int deleteDepartment(int departmentId);
    int editDepartment(int departmentId, String departmentName, String departmentAdress, double departmentScore);
    double calculateDepartmentScore(int departmentId);
}
