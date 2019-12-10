package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Review;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.ProjectVariables;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class ReviewRepositoryImpl implements ReviewRepository{


    public int createReview(Review review, int userId, int departmentId) {


        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO saltyfirm.review (post, salary, position, pension_scheme, benefits," +
                    "management, work_environment, flexibility, employment_time, user_fk_id, department_fk_id) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, review.getPost());
            preparedStatement.setInt(2, review.getSalary());
            preparedStatement.setString(3, review.getPosition());
            preparedStatement.setInt(4, review.getPensionScheme());
            preparedStatement.setInt(5, review.getBenefits());
            preparedStatement.setInt(6, review.getManagement());
            preparedStatement.setInt(7, review.getWorkEnvironment());
            preparedStatement.setInt(8, review.getFlexibility());
            preparedStatement.setInt(9, review.getEmploymentTime());
            preparedStatement.setInt(10, userId);
            preparedStatement.setInt(11, departmentId);

            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int editReview(Review review, int userId, int departmentId) {

       /* try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE saltyfirm.review")
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        return 0;
    }

    public int deleteReview(int reviewId) {

        return 0;
    }

}
