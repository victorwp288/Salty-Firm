package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.DatabaseConnection.DbHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("UserRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HashRepository hashRepository;

    @Autowired
    DbHandler dbHandler;

    /**
     * @author Martin & Nicholas.
     *
     *
     */

    @Override
    public int createUser(User user) {
        log.info("Creating user");
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement ("INSERT INTO saltyfirm.user (username, password, firstname, lastname, phone_number, gender, birthdate, education, mail, nationality, privileges_fk_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hashRepository.hashPassword(user.getPassword()));
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setInt(5, user.getPhoneNumber());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getBirthdate());
            preparedStatement.setString(8, user.getEducation());
            preparedStatement.setString(9, user.getMail());
            preparedStatement.setString(10, user.getNationality());
            preparedStatement.setInt(11, 2);

            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * @author Martin & Nicholas.
     * @param user
     * @return 0
     */

    @Override
    public int editUser(User user) {
        log.info("Editing user");
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE saltyfirm.user SET username = ?, password = ?, firstname = ?, lastname = ?, phone_number = ?, gender = ?, birthdate = ?, education = ?, mail = ?, nationality = ?, privileges_fk_id = ? WHERE user_id = ?");

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hashRepository.hashPassword(user.getPassword()));
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setInt(5, user.getPhoneNumber());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getBirthdate());
            preparedStatement.setString(8, user.getEducation());
            preparedStatement.setString(9, user.getMail());
            preparedStatement.setString(10, user.getNationality());
            if (user.getPrivileges().equals("Administrator")) {
                preparedStatement.setString(11, "1");
            } else if (user.getPrivileges().equals("Bruger")) {
                preparedStatement.setString(11, "2");
            } else {
                preparedStatement.setString(11, "3");
            }
            preparedStatement.setInt(12, user.getUserId());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(int userId) {
        log.info("Deleting user");
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM saltyfirm.user WHERE user_id = ?");
            preparedStatement.setInt(1,userId);
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @author Nicholas / Martin
     * @return
     */

    @Override
    public List<User> getAllUsers() {
        log.info("Fetching all users");
        List<User> usersList = new ArrayList<>();

        try {
            Connection connection = dbHandler.createConnection();
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
                current.setBirthdate(resultSet.getString("birthdate"));
                current.setEducation(resultSet.getString("education"));
                current.setMail(resultSet.getString("mail"));
                current.setNationality(resultSet.getString("nationality"));
                current.setPrivileges(resultSet.getString("access_level"));
                usersList.add(current);
            }
            connection.close();
        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }
        return usersList;
    }

    /**
     * @author Nicholas / Martin
     * @param userId
     * @return
     */

    @Override
    public User findUserById(int userId) {
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.user LEFT JOIN saltyfirm.privileges ON user.privileges_fk_id = privileges.privileges_id WHERE user_id = ?");


            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                User current = new User();

                current.setUserId(resultSet.getInt("user_id"));
                current.setUsername(resultSet.getString("username"));
                current.setPassword(resultSet.getString("password"));
                current.setFirstname(resultSet.getString("firstname"));
                current.setLastname(resultSet.getString("lastname"));
                current.setPhoneNumber(resultSet.getInt("phone_number"));
                current.setGender(resultSet.getString("gender"));
                current.setBirthdate(resultSet.getString("birthdate"));
                current.setEducation(resultSet.getString("education"));
                current.setMail(resultSet.getString("mail"));
                current.setNationality(resultSet.getString("nationality"));
                current.setPrivileges(resultSet.getString("access_level"));

                return current;

            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @author Nicholas / Martin
     *
     *<p>
     * checkLogin searches user tabel for a user where username and password matches username and password in the database.
     * The user will be left joined with the privileges tabel with privileges_fk_id and match it with privileges_id.
     * This returns a user and his privliges and access level.
     *</p>
     *
     * @param username username for user object
     * @param password password for user object
     *
     * @throws SQLException
     * @return user if username and password matches username and password in the database, otherwise null.
     */
    @Override
    public User checkLogin(String username, String password) {
        log.info("Validating Login");
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.user LEFT JOIN saltyfirm.privileges ON saltyfirm.user.privileges_fk_id = privileges.privileges_id WHERE user.username = ? AND user.password = ?");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashRepository.hashPassword(password));

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                User user = new User();

                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setPhoneNumber(resultSet.getInt("phone_number"));
                user.setGender(resultSet.getString("gender"));
                user.setBirthdate(resultSet.getString("birthdate"));
                user.setEducation(resultSet.getString("education"));
                user.setMail(resultSet.getString("mail"));
                user.setNationality(resultSet.getString("nationality"));
                user.setPrivileges(resultSet.getString("access_level"));

                connection.close();

                return user;
            }

        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }
        return null;
    }
}
