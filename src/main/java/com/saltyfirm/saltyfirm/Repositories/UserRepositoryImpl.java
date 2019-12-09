package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.DatabaseHelper.DatabaseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    DatabaseHandler databaseHandler;

    public int createUser(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String privileges) {

        return 0;
    }

    public int editUser(int userId, String username, String password, String firstname, String lastname, int phoneNumber, String gender, Date birthdate, String education, String mail, String nationality, String privileges) {

        return 0;
    }

    public int deleteUser(int userId) {

        return 0;
    }

    public List<User> getAllUsers() {

        List<User> usersList = new ArrayList<>();

        try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "test1234", "test1234");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM saltyfirm.user LEFT JOIN  saltyfirm.privileges ON user.privileges_fk_id = privileges.privileges_id");

            while (resultSet.next()) {
                User users = new User();

                users.setUserId(resultSet.getInt("user_id"));
                users.setUsername(resultSet.getString("username"));
                users.setPassword(resultSet.getString("password"));
                users.setFirstname(resultSet.getString("firstname"));
                users.setLastname(resultSet.getString("lastname"));
                users.setPhoneNumber(resultSet.getInt("phone_number"));
                users.setGender(resultSet.getString("sex"));
                users.setBirthdate(resultSet.getDate("birthdate"));
                users.setEducation(resultSet.getString("education"));
                users.setMail(resultSet.getString("mail"));
                users.setNationality(resultSet.getString("nationality"));
                users.setPrivileges(resultSet.getString("privileges_fk_id"));

                usersList.add(users);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersList;
    }

    public int findUserById(int userId) {

        return 0;
    }

    public User checkLogin(String user) {

        return null;
    }
}
