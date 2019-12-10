package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.ProjectVariables;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentRepositoryImpl implements DepartmentRepository {


    public Department findDepartmentById(int departmentId) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.department WHERE department_id = ?");
            preparedStatement.setInt(1,departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Department department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setDepartmentAddress(resultSet.getString("department_address"));
                department.setDepartmentScore(resultSet.getDouble("department_score"));
                return department;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Department> getDepartments(int firmId) {
        List<Department> departmentsList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.department WHERE firm_fk_id = ?");
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
            connection.close();
            return departmentsList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

    public int editDepartment(Department department) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE saltyfirm.department SET department_name = ?, department_address = ? WHERE department_id = ?");
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setString(2, department.getDepartmentAddress());
            preparedStatement.setInt(3, department.getDepartmentId());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Double> calculateDepartmentScore(int departmentId) {
        List<Double> scores = new ArrayList<>();
        int pensionScheme = 0; int benefits = 0; int management = 0; int workEnvironment = 0; int flexibility = 0; int counter = 0;
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.review WHERE department_fk_id = ?");
            preparedStatement.setInt(1,departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                pensionScheme += resultSet.getInt("pension_scheme");
                benefits += resultSet.getInt("benefits");
                management += resultSet.getInt("management");
                workEnvironment += resultSet.getInt("work_environment");
                flexibility += resultSet.getInt("flexibility");
                counter++;
            }
            connection.close();
            scores.add( (double) pensionScheme / counter);
            scores.add( (double) benefits / counter);
            scores.add( (double) management / counter);
            scores.add( (double) workEnvironment / counter);
            scores.add( (double) flexibility / counter);
            scores.add( (double) (pensionScheme+benefits+management+workEnvironment+flexibility) / (counter*5));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scores;
    }

}
