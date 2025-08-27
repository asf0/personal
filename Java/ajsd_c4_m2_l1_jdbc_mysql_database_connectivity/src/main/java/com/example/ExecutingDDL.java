package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecutingDDL {
    private static Connection getDababaseConnection() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "x";
        String password = "";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed SQLException: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Connection failed Exception: " + e.getMessage());
            return null;
        }
    }

    public static void createDatabase(Connection conn) throws SQLException {
        String checkQuery = "SELECT 1 from pg_database where datname = 'realestatedb'";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(checkQuery)) {
            if (!rs.next()) {
                stmt.executeUpdate("CREATE DATABASE realestatedb");
                System.out.println("Database 'realestatedb' created successfully");
            } else {
                System.out.println("Database 'realestatedb' already exists.");
            }
        }
    }

    public static void createTableExecute(Connection conn) {
        String createPropertiesTableSQL = """
                CREATE TABLE IF NOT EXISTS housing_property (
                property_id SERIAL PRIMARY KEY,
                address  VARCHAR(255),
                type VARCHAR(50),
                rent_price DECIMAL(10, 2)
                )
                """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createPropertiesTableSQL);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }

    }

    public static void addParkingSpaceColumn(Connection conn) {
        String alterTableSQL = """
                ALTER TABLE housing_property
                ADD COLUMN IF NOT EXISTS parking_spaces INT;
                """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(alterTableSQL);
            System.out.println("Column 'parking_spaces' added successfully");
        } catch (SQLException e) {
            System.out.println("Error adding column: " + e.getMessage());
        }
    }
    public static void dropPropertiesTable(Connection conn) {
        String dropTableSQL = "DROP TABLE IF EXISTS housing_property";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(dropTableSQL);
            System.out.println("Table 'housing_property' dropped successfully.");
        } catch (SQLException e) {
            System.out.println("Error dropping table: " +  e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Connection x = getDababaseConnection();
            if (x != null) {
                createDatabase(x);
            }
            createTableExecute(x);
            addParkingSpaceColumn(x);
            dropPropertiesTable(x);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
