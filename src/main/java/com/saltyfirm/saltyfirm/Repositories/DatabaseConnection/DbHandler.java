package com.saltyfirm.saltyfirm.Repositories.DatabaseConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DbHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Connection connection;

    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    public Connection createConnection() {
        try {
            log.info("Connection to Database");
            connection = DriverManager.getConnection(springDatasourceUrl, dbUsername, dbPassword);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }



}
