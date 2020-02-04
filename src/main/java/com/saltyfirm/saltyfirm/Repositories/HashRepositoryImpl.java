package com.saltyfirm.saltyfirm.Repositories;


import com.saltyfirm.saltyfirm.Models.User;
import com.saltyfirm.saltyfirm.Repositories.DatabaseConnection.DbHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

// Victor Petersen

@Repository("HashRepositoryImpl")
public class HashRepositoryImpl implements HashRepository{

    @Autowired
    DbHandler dbHandler;


    //No changing simple salt, that gets added to the end of the password
    private final String salt = "n0 H4Ck My p422W0rD";

    /**
     * @author Victor
     * <P>
     *     Takes a password and processes it though MessageDigest
     *     With the SHA-256 algorithm.
     *     It starts from the beginning and runs through the lenght of the password
     *     after that it returns the hashed password as hexadecimal
     *     0-9, a-f
     * </P>
     * @param password String
     * @return the hashed password or null
     */
    @Override
    public String hashPassword(String password) {


        if (password == null) {
            return null;
        }

        password = password + salt;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");    // One way hashing algorithm.
            md.update(password.getBytes(), 0, password.length());
            String hashedPassword = new BigInteger(1, md.digest()).toString(16);

            return hashedPassword;


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean usernameExists(User user) {
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
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean passwordExists(User user) {
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
            e.printStackTrace();
        }
        return false;
    }
}
