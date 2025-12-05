package com.pluralsight.data;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class DataManager {

    private Connection connection;

    public DataManager(String database, String username, String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/" + database);
        ds.setUsername(username);
        ds.setPassword(password);

        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}