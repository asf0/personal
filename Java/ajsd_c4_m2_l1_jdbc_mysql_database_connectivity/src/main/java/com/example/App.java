package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class App
{
    private static Properties dbProperties = null;

        private static void loadDatabaseProperties() {
        if (dbProperties == null) {
            dbProperties = new Properties();
            try (InputStream input = App.class.getClassLoader().getResourceAsStream("database.properties")) {
                if (input == null) {
                    System.err.println("Unable to find database.properties file");
                    return;
                }
                dbProperties.load(input);
                System.out.println("Database properties loaded successfully");
            } catch (IOException e) {
                System.err.println("Error loading database properties: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    public static void main( String[] args ) {
        String url = "jdbc:postgresql://localhost:5432/chinook";
        String user = "x";
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