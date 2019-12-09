package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public int findDepartmentById(int departmentId) {

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
    public int editDepartment(int departmentId, String departmentName, String departmentAddress, double departmentScore) {

        return departmentRepository.editDepartment(departmentId, departmentName, departmentAddress, departmentScore);
    }

    @Override
    public double calculateDepartmentScore(int departmentId) {

        return departmentRepository.calculateDepartmentScore(departmentId);
    }

}
