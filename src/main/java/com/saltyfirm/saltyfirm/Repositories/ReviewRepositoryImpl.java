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

    @Override
    public int createReview(Review review, int userId, int departmentId) {

        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO saltyfirm.review (post, salary, position, pension_scheme, benefits," +
                    "management, work_environment, flexibility, employment_time, user_fk_id, department_fk_id) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, review.getPost());
            preparedStatement.setInt(2, review.getSalary());
            preparedStatement.setString(3, review.getPosition());
            preparedStatement.setDouble(4, review.getPensionScheme());
            preparedStatement.setDouble(5, review.getBenefits());
            preparedStatement.setDouble(6, review.getManagement());
            preparedStatement.setDouble(7, review.getWorkEnvironment());
            preparedStatement.setDouble(8, review.getFlexibility());
            preparedStatement.setInt(9, review.getEmploymentTime());
            preparedStatement.setInt(10, userId);
            preparedStatement.setInt(11, departmentId);

            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("UPDATE saltyfirm.department \n" +
                                                                "SET department_score = \n" +
                                                                "  (SELECT\n" +
                                                                "    (SELECT SUM(pension_scheme + benefits + management + work_environment + flexibility) / 5 AS total_score) /\n" +
                                                                "    (SELECT COUNT(benefits)) AS total_total_score\n" +
                                                                "    FROM review\n" +
                                                                "    WHERE department_fk_id = department_id) \n" +
                                                                "WHERE department_id = ?;");
            preparedStatement.setInt(1, departmentId);
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int editReview(Review review, int departmentId) {

        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE saltyfirm.review SET post, salary, position, pension_scheme, benefits, " +
                    "management, work_environment, flexibility, employment_time VALUE (?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, review.getPost());
            preparedStatement.setInt(2, review.getSalary());
            preparedStatement.setString(3, review.getPosition());
            preparedStatement.setDouble(4, review.getPensionScheme());
            preparedStatement.setDouble(5, review.getBenefits());
            preparedStatement.setDouble(6, review.getManagement());
            preparedStatement.setDouble(7, review.getWorkEnvironment());
            preparedStatement.setDouble(8, review.getFlexibility());
            preparedStatement.setInt(9, review.getEmploymentTime());

            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("UPDATE saltyfirm.department \n" +
                                                                "SET department_score = \n" +
                                                                "  (SELECT\n" +
                                                                "    (SELECT SUM(pension_scheme + benefits + management + work_environment + flexibility) / 5 AS total_score) /\n" +
                                                                "    (SELECT COUNT(benefits)) AS total_total_score\n" +
                                                                "    FROM review\n" +
                                                                "    WHERE department_fk_id = department_id) \n" +
                                                                "WHERE department_id = ?;");

            preparedStatement.setInt(1, departmentId);
            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 0;
    }

    @Override
    public int deleteReview(int reviewId, int departmentId) {

        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM saltyfirm.review WHERE review_id = ?");

            preparedStatement.setInt(1, reviewId);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("UPDATE saltyfirm.department \n" +
                                                                "SET department_score = \n" +
                                                                "  (SELECT\n" +
                                                                "    (SELECT SUM(pension_scheme + benefits + management + work_environment + flexibility) / 5 AS total_score) /\n" +
                                                                "    (SELECT COUNT(benefits)) AS total_total_score\n" +
                                                                "    FROM review\n" +
                                                                "    WHERE department_fk_id = department_id) \n" +
                                                                "WHERE department_id = ?;");

            preparedStatement.setInt(1, departmentId);
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 0;
    }

}
