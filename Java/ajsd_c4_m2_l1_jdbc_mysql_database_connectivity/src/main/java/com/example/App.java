package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.sql.Driver;

public class App
{
    public static void main( String[] args ) {
        String url = "jdbc:postgresql://localhost:5432/chinook";
        String user = "ataide";
        String password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("connected to the database");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed " + e);

        }
    }
}









//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Enumeration<Driver> drivers = DriverManager.getDrivers();
//            while (drivers.hasMoreElements()) {
//                System.out.println(drivers.nextElement().getClass().getName());
//            }

//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver class not found, can't load the driver");
//        }