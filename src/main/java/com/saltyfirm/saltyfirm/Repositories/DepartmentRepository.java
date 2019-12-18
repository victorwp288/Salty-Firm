package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Models.Review;

import java.util.List;

public interface DepartmentRepository {

    Department findDepartmentById(int departmentId);
    List<Department> getDepartments(int firmId);
    int deleteDepartment(int departmentId);
    int editDepartment(Department department);
    int updateDepartmentScore(int departmentId);
    Review getRealDepartmentScores(int departmentId);
}
