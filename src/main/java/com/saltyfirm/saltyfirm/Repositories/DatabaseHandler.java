package com.saltyfirm.saltyfirm.Repositories;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseHandler {

    private Connection connection;

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    private String datasourceUrl = "jdbc:mysql://saltyfirmdb.cxgtaawn9fts.eu-central-1.rds.amazonaws.com:3306";

    private String dbUsername = "SaltyFirm";

    private String dbPassword = "SaltyFirm";


    public Connection createConnection() {
        try {
            log.info("CreateConnection: Trying to get connection");
            connection = DriverManager.getConnection(datasourceUrl, dbUsername, dbPassword);
            log.info("CreateConnection: Connection complete");
        } catch (SQLException e) {
            log.info("CreateConnection: Fangede SQLException");
            e.printStackTrace();
        }
        log.info("CreateConnection: Returning connection");
        return connection;
    }

}
