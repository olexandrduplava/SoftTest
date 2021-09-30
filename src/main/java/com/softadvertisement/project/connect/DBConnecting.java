package com.softadvertisement.project.connect;

import java.sql.*;
import org.postgresql.Driver;
import java.sql.Connection;

public class DBConnecting {


    public static Connection getConnection() throws SQLException {

        String URL = "jdbc:postgresql://localhost:5432/SoftTest";
        String USERNAME = "postgres";
        String PASSWORD = "1234";

        DriverManager.registerDriver(new Driver());

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
