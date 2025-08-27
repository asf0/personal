package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.ds.PGSimpleDataSource;

public class DataSourceConnectionHelper {

    public static void connect(String databaseURL, String username, String password) {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL(databaseURL);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setDatabaseName("chinook");
        try (
                Connection conn = dataSource.getConnection();
                Statement sqlStatement = conn.createStatement();
                ResultSet queryResultSet = sqlStatement.executeQuery("SELECT * FROM album");
        ) {
            System.out.println("Connected");
            while (queryResultSet.next()) {
                System.out.println(queryResultSet.getArray("title"));
            }
        } catch (SQLException e) {
            System.err.println("could not connect");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/";
        String user = "x";
        String password = "";
        connect(url, user, password);
    }
}
