package com.pluralsight.data;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataManager {

    private BasicDataSource dataSource;

    public DataManager(String database, String username, String password) {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/" + database);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // Optional: Pool settings
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);
    }

    // Get a new connection from the pool
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
