package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseHandler {

    private final String url = "jdbc:postgresql://localhost:5432/chinook";
    private final String user = "ataide";
    private final String passwd = "123";

    @SuppressWarnings("exports")
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, passwd);
    }

    public String getAllUsers() throws SQLException {
        String userData = "";
        String query = "SELECT * FROM customer";
        Connection clickb = getConnection();
        Statement queryStatement = clickb.createStatement();
        ResultSet rst = queryStatement.executeQuery(query);

// Corrected code
    while (rst.next()) {
        userData += rst.getInt("customer_id") + " " +
        rst.getString("first_name") + " " +
        rst.getString("last_name") + " " +
        rst.getString("email") + "\n";
    }
        return userData;
    }

    public ObservableList<User> getUsersAsObservableList() throws SQLException {
        ObservableList<User> users = FXCollections.observableArrayList();
        String query = "SELECT * FROM customer";
        Connection clickb = getConnection();
        Statement queryStatement = clickb.createStatement();
        ResultSet rst = queryStatement.executeQuery(query);

        while (rst.next()) {
        int customerId = rst.getInt("customer_id");
        String firstName = rst.getString("first_name");
        String lastName = rst.getString("last_name");
        String email = rst.getString("email");
        User newUser = new User(customerId, firstName, lastName, email);
        users.add(newUser);
        }
        rst.close();
        queryStatement.close();
        clickb.close();
        return users;
    }
}
