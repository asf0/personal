package com.example;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.*;

public class JDBCstatements {
    public static void main( String[] args ) {
        String url = "jdbc:postgresql://localhost:5432/chinook";
        String user = "ataide";
        String password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement stmt = connection.createStatement();

            String sql = "INSERT INTO Track(track_id, name, album_id, media_type_id," + "genre_id, composer, milliseconds, bytes, unit_price)" +
                    "VALUES(7500, 'New Track',1,2,5, 'Composer Name', 300000, 5000000, 0.99)";
            int rowsAffected =  stmt.executeUpdate(sql);
            System.out.println("Rows affected " + rowsAffected);

//            // Challange
//
//            String query = "SELECT name from Track WHERE genre_id = (SELECT genre_id FROM Genre WHERE name = ?)";
//            PreparedStatement pstmt = connection.prepareStatement(query);
//            pstmt.setString(1, "Rock");
//            ResultSet rs = pstmt.executeQuery();
//
//            while(rs.next()) {
//                String trackName = rs.getString("name");
//                System.out.println("Track: " + trackName);
//            }
//            rs.close();
//            pstmt.close();



            // Method 3
//            // prepare the callable statement for the function
//            CallableStatement cstmt = connection.prepareCall("SELECT * FROM sales_report");
//            // execute it
//            ResultSet rs = cstmt.executeQuery();
//            // Iterate it
//            while(rs.next()) {
//                int invoiceId = rs.getInt("invoice_id");
//                double total = rs.getDouble("total");
//                System.out.println("Invoice ID: " + invoiceId + ", Total: " + total);
//            }
//            rs.close();
//            cstmt.close();




            //Method 2
//            String query = "SELECT title from Album WHERE artist_id = (SELECT artist_id FROM Artist WHERE name = ?)";
//            PreparedStatement pstmt = connection.prepareStatement(query);
//            pstmt.setString(1,"AC/DC");
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                System.out.println("Album: " + rs.getString("title"));
//            }
//            rs.close();
//            pstmt.close();

            //Method 1

//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT name from Artist");
//            while (rs.next()) {
//                System.out.println("Artist: " + rs.getString("name"));
//            }
//            rs.close();
//            stmt.close();


        } catch (SQLException e) {
            System.out.println("Connection failed " + e);

        }
    }
}
