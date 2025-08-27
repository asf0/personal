package com.example;

import java.sql.*;

public class  inventoryManagement {
    public static void main(String[] args) {
        Connection conn = getDatabaseConnection();
        if(conn != null) {
            System.out.println("Connected to the database successfully");
            try {
                String createTableSQL = """
                        CREATE TABLE IF NOT EXISTS products (
                        product_id INT PRIMARY KEY,
                        quantity INT);
                        """;
                Statement stmt = conn.createStatement();
                stmt.execute(createTableSQL);
                System.out.println("Table 'products' created or already exists.");

                //Disable auto-commit mode
                conn.setAutoCommit(false);
                System.out.println("Auto-commit disabled. Transactions will be managed manually.");

                // prepared statement

                String insertProductSQL = "INSERT INTO products (product_id, quantity) VALUES(?,?);";
                PreparedStatement pstmt = conn.prepareStatement(insertProductSQL);

                // inser 1 product(smartphone)
                pstmt.setInt(1, 1);
                pstmt.setInt(2, 50);
                pstmt.executeUpdate();
                System.out.println("Product 1: Smartphones inserted with quantity 50.");

                //insert 2 product 2 laptop

                pstmt.setInt(1, 2);
                pstmt.setInt(2, 100);
                pstmt.executeUpdate();
                System.out.println("Product 2: laptop inserted with quantity 100.");

                // Update product 2

                String updateProduct2SQL = "UPDATE products SET quantity = quantity + 20 WHERE product_id = ?";
                PreparedStatement updateProduct2stmt = conn.prepareStatement(updateProduct2SQL);
                updateProduct2stmt.setInt(1, 2);
                updateProduct2stmt.executeUpdate();
                System.out.println("Product 2: Laptops quantity updated by adding more 20");

                // commit transaction
                conn.commit();
                System.out.println("Commited successfully");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        } else {
            System.out.println("Failed to connect to the database.");
        }

    }

    public static Connection getDatabaseConnection() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "123";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}
