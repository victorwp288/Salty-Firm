package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Department;
import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.ProjectVariables;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentRepositoryImpl implements DepartmentRepository {

    @Override
    public Department findDepartmentById(int departmentId) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.department WHERE department_id = ?");
            preparedStatement.setInt(1, departmentId);
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

    @Override
    public List<Department> getDepartments(int firmId) {
        List<Department> departmentsList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.department WHERE firm_fk_id = ?");
            preparedStatement.setInt(1, firmId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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

    @Override
    public int deleteDepartment(int departmentId) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM saltyfirm.department WHERE department_id = ?");
            preparedStatement.setInt(1, departmentId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int editDepartment(Department department) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
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

    @Override
    public List<Double> getDepartmentScores(int departmentId) {
        List<Double> scores = new ArrayList<>();
        int pensionScheme = 0;
        int benefits = 0;
        int management = 0;
        int workEnvironment = 0;
        int flexibility = 0;
        int counter = 0;
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.review WHERE department_fk_id = ?");
            preparedStatement.setInt(1, departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                pensionScheme += resultSet.getInt("pension_scheme");
                benefits += resultSet.getInt("benefits");
                management += resultSet.getInt("management");
                workEnvironment += resultSet.getInt("work_environment");
                flexibility += resultSet.getInt("flexibility");
                counter++;
            }

            scores.add((double) pensionScheme / counter);
            scores.add((double) benefits / counter);
            scores.add((double) management / counter);
            scores.add((double) workEnvironment / counter);
            scores.add((double) flexibility / counter);
            scores.add((double) (pensionScheme + benefits + management + workEnvironment + flexibility) / (counter * 5));

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scores;
    }

    @Override
    public Review getRealDepartmentScores(int departmentId) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT AVG(pension_scheme), AVG(benefits), AVG(management), AVG(work_environment), AVG(flexibility), AVG((pension_scheme + benefits + management + work_environment + flexibility)/5) AS overall_score\n" +
                                                                                   "FROM saltyfirm.review\n" +
                                                                                   "WHERE department_fk_id = ?;");
            preparedStatement.setInt(1, departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Review review = new Review();
                review.setPensionScheme(resultSet.getDouble(1));
                review.setBenefits(resultSet.getDouble(2));
                review.setManagement(resultSet.getDouble(3));
                review.setWorkEnvironment(resultSet.getDouble(4));
                review.setFlexibility(resultSet.getDouble(5));
                review.setDepartmentOverallScore(resultSet.getDouble("overall_score"));

                return review;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int updateDepartmentScore(int departmentId) {
        List<Double> scores = getDepartmentScores(departmentId);
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE saltyfirm.department SET department_score = ? WHERE department_id = ?");
            preparedStatement.setDouble(1, scores.get(5));
            preparedStatement.setInt(2, departmentId);
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Review> getAllReviews(int departmentId) {
        List<Review> reviews = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.review WHERE department_fk_id = ?");
            preparedStatement.setInt(1, departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Review review = new Review();
                review.setReviewId(resultSet.getInt("review_id"));
                review.setPost(resultSet.getString("post"));
                review.setSalary(resultSet.getInt("salary"));
                review.setPosition(resultSet.getString("position"));
                review.setPensionScheme(resultSet.getInt("pension_scheme"));
                review.setBenefits(resultSet.getInt("benefits"));
                review.setManagement(resultSet.getInt("management"));
                review.setWorkEnvironment(resultSet.getInt("work_environment"));
                review.setFlexibility(resultSet.getInt("flexibility"));
                review.setEmploymentTime(resultSet.getInt("employment_time"));
                reviews.add(review);
            }
            connection.close();
            return reviews;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
