package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Department;

import java.util.List;

public interface DepartmentService {

    Department findDepartmentById(int departmentId);
    List<Department> getDepartments(int firmId);
    int deleteDepartment(int departmentId);
    int editDepartment(Department department);
    List<Double> calculateDepartmentScore(int departmentId);
}
