package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department findDepartmentById(int departmentId) {

        return departmentRepository.findDepartmentById(departmentId);
    }

    @Override
    public List<Department> getDepartments(int firmId) {

        return departmentRepository.getDepartments(firmId);
    }

    @Override
    public int deleteDepartment(int departmentId) {

        return departmentRepository.deleteDepartment(departmentId);
    }

    @Override
    public int editDepartment(Department department) {

        return departmentRepository.editDepartment(department);
    }

    @Override // SKAL SLETTES, DENNE FINDES I getRealDepartmentScore
    public List<Double> getDepartmentScores(int departmentId) {

        return departmentRepository.getDepartmentScores(departmentId);
    }

    @Override
    public int updateDepartmentScore(int departmentId) {

        return departmentRepository.updateDepartmentScore(departmentId);
    }

    @Override
    public List<Review> getAllReviews(int departmentId) {

        return departmentRepository.getAllReviews(departmentId);
    }

    public Review getRealDepartmentScores(int departmentId) {
        return departmentRepository.getRealDepartmentScores(departmentId);
    }

}
