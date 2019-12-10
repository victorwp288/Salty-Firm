package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Models.Review;

import java.util.List;

public interface DepartmentRepository {

    Department findDepartmentById(int departmentId);
    List<Department> getDepartments(int firmId);
    int deleteDepartment(int departmentId);
    int editDepartment(Department department);
    List<Double> getDepartmentScores(int departmentId);
    int updateDepartmentScore(int departmentId);
    List<Review> getAllReviews(int departmentId);
}
