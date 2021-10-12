package com.softadvertisement.project.connect;

import java.sql.*;
import org.postgresql.Driver;
import java.sql.Connection;
import java.util.Properties;

public class DBConnecting {

//    private static final String URL_KEY = "db.url";
//    private static final String USERNAME_KEY = "db.username";
//    private static final String PASSWORD_KEY = "db.password";

    public static Connection getConnection() throws SQLException {

        String URL = "jdbc:postgresql://localhost:5432/SoftTest";
        String USERNAME = "postgres";
        String PASSWORD = "1234";

        DriverManager.registerDriver(new Driver());

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);



    }
}
