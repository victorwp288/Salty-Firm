package com.saltyfirm.saltyfirm.Repositories.DatabaseHelper;

import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {

    private Connection connection;


    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    private String datasourceUrl = "jdbc:mysql://localhost:3306";

    private String dbUsername = "test1234";

    private String dbPassword = "test1234";

    public Connection createConnection() {
        try {
            log.info("createConnection: Trying to get connection");
            connection = DriverManager.getConnection(datasourceUrl, dbUsername, dbPassword);
            log.info("createConnection: Connection complete");
        } catch (SQLException e) {
            log.info("createConnection: catched SQLException");
            e.printStackTrace();
        }
        log.info("createConnection: Returning connection");
        return connection;
    }

    public void closeConnection() {
        try {
            log.info("closeConnection: Trying to close connection");
            connection.close();
            log.info("closeConnection: Connection closed");
        } catch (SQLException e) {
            log.info("closeConnection: catched SQLException");
            e.printStackTrace();
        }
    }

}
