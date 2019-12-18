package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Repositories.DepartmentRepository;
import com.saltyfirm.saltyfirm.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ReviewRepository reviewRepository;

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


    @Override
    public int updateDepartmentScore(int departmentId) {

        return departmentRepository.updateDepartmentScore(departmentId);
    }



    public Review getRealDepartmentScores(int departmentId) {
        return departmentRepository.getRealDepartmentScores(departmentId);
    }

}
