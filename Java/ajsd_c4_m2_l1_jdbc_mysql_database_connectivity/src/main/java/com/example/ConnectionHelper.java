package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public static void connect(String databaseURL, String userName, String password) {
        try (Connection dbConn = DriverManager.getConnection(databaseURL, userName, password)) {
            if (dbConn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException e) {
            System.err.println("could not connect");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/chinook";
        String user = "ataide";
        String password = "";
        connect(url, user, password);
    }
}
