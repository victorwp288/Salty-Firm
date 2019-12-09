package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.DatabaseHandler;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.ProjectVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    DatabaseHandler databaseHandler;

    @Override
    public int createUser(User user) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement ("INSERT INTO saltyfirm.user (username, password, firstname, lastname, phone_number, gender, birthdate, education, mail, nationality, privileges_fk_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setInt(5, user.getPhoneNumber());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setDate(7, new java.sql.Date(user.getBirthdate().getTime()));
            preparedStatement.setString(8, user.getEducation());
            preparedStatement.setString(9, user.getMail());
            preparedStatement.setString(10, user.getNationality());
            preparedStatement.setString(11, user.getPrivileges());

            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int editUser(User user) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE saltyfirm.user SET (username, `password`, firstname, lastname, phone_number, gender, birthdate, education, mail, nationality, privileges_fk_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setInt(5, user.getPhoneNumber());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setDate(7, new java.sql.Date(user.getBirthdate().getTime()));
            preparedStatement.setString(8, user.getEducation());
            preparedStatement.setString(9, user.getMail());
            preparedStatement.setString(10, user.getNationality());
            preparedStatement.setString(11, user.getPrivileges());

            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(int userId) {
        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(),ProjectVariables.getUsername(),ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM saltyfirm.user WHERE user_id = ?");
            preparedStatement.setInt(1,userId);
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> usersList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM saltyfirm.user LEFT JOIN  saltyfirm.privileges ON user.privileges_fk_id = privileges.privileges_id");

            while (resultSet.next()) {
                User current = new User();

                current.setUserId(resultSet.getInt("user_id"));
                current.setUsername(resultSet.getString("username"));
                current.setPassword(resultSet.getString("password"));
                current.setFirstname(resultSet.getString("firstname"));
                current.setLastname(resultSet.getString("lastname"));
                current.setPhoneNumber(resultSet.getInt("phone_number"));
                current.setGender(resultSet.getString("gender"));
                current.setBirthdate(resultSet.getDate("birthdate"));
                current.setEducation(resultSet.getString("education"));
                current.setMail(resultSet.getString("mail"));
                current.setNationality(resultSet.getString("nationality"));
                current.setPrivileges(resultSet.getString("access_level"));
                usersList.add(current);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public User findUserById(int userId) {
        for (User currentUser : getAllUsers()) {
            if (userId == currentUser.getUserId()) {
                return currentUser;
            }
        }
        return null;
    }

    @Override
    public User checkLogin(String username, String password) {

        try {
            Connection connection = DriverManager.getConnection(ProjectVariables.getUrl(), ProjectVariables.getUsername(), ProjectVariables.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.user LEFT JOIN saltyfirm.privileges ON saltyfirm.user.privileges_fk_id = privileges.privileges_id WHERE user.username = ? AND user.password = ?");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet =preparedStatement.executeQuery();

            if (resultSet.next()){
                User user = new User();

                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setPhoneNumber(resultSet.getInt("phone_number"));
                user.setGender(resultSet.getString("sex"));
                user.setBirthdate(resultSet.getDate("birthdate"));
                user.setEducation(resultSet.getString("education"));
                user.setMail(resultSet.getString("mail"));
                user.setNationality(resultSet.getString("nationality"));
                user.setPrivileges(resultSet.getString("access_level"));

                connection.close();

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
