package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.ProjectVariables;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentRepositoryImpl implements DepartmentRepository {


    public int findDepartmentById(int departmentId) {

        return 0;
    }

    public List<Department> getDepartments(int firmId) {
        List<Department> departmentsList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.department WHERE firm_fk_id LIKE ?");
            preparedStatement.setInt(1, firmId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Department currentDepartment = new Department();

                currentDepartment.setDepartmentId(resultSet.getInt("department_id"));
                currentDepartment.setDepartmentName(resultSet.getString("department_name"));
                currentDepartment.setDepartmentAddress(resultSet.getString("department_address"));
                currentDepartment.setDepartmentScore(resultSet.getDouble("department_score"));

                departmentsList.add(currentDepartment);
            }

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentsList;
    }

    public int deleteDepartment(int departmentId) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM saltyfirm.department WHERE department_id = ?");
            preparedStatement.setInt(1,departmentId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int editDepartment(int departmentId, String departmentName, String departmentAddress, double departmentScore) {

        return 0;
    }

    public double calculateDepartmentScore(int departmentId) {

        return 0;
    }

}
