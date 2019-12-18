package com.saltyfirm.saltyfirm.Repositories;


import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.DatabaseConnection.DbHandler;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


@Repository("HashRepositoryImpl")
public class HashRepositoryImpl implements HashRepository{

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    DbHandler dbHandler;

    /**
     *
     */
    private final String salt = "n0 H4Ck My p422W0rD";

    /**
     *
     * @param password
     * @return
     */
    @Override
    public String hashPassword(String password) {
        log.info("Hashing passord");

        if (password == null) {
            return null;
        }

        password = password + salt;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes(), 0, password.length());
            String hashedPassword = new BigInteger(1, md.digest()).toString(16);

            return hashedPassword;


        } catch (NoSuchAlgorithmException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean usernameExists(User user) {
        log.info("Checking whether username exists");
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.`user` WHERE username = ?");
            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            User current = new User();

            while (resultSet.next()) {
                current.setUsername(resultSet.getString("username"));
                if (current.getUsername().equals(user.getUsername())) {
                    return true;
                }
            }
        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean passwordExists(User user) {
        log.info("Checking whether password exists");
        try {
            Connection connection = dbHandler.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM saltyfirm.`user` WHERE password = ?");
            preparedStatement.setString(1, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            User current = new User();

            while (resultSet.next()) {
                current.setPassword(resultSet.getString("password"));
                if (current.getPassword().equals(user.getPassword())) {
                    return true;
                }
            }
        } catch (SQLException e) {
            log.warn("Found SQLException: ");
            e.printStackTrace();
        }
        return false;
    }
}
