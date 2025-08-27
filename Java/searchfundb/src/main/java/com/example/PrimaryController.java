package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnRead;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField fNameField;

    @FXML
    private TextField lNameField;

    @FXML
    private TextField pointsField;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<User, String> fnameColumn;

    @FXML
    private TableColumn<User, String> lnameColumn;

    @FXML
    private TableColumn<User, Integer> pointsColumn;

    @FXML
    private TableView<User> tableView;
    
    private static Properties dbProperties = null;

    @FXML
    public void initialize() {
        // Changed to lowercase to match getter method names
        fnameColumn.setCellValueFactory(new PropertyValueFactory<>("fname"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<>("lname"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        refreshTable();
    }
    
    private void refreshTable() {
        tableView.setItems(getAllUsers());
    }

        private static void loadDatabaseProperties() {
        if (dbProperties == null) {
            dbProperties = new Properties();
            try (InputStream input = PrimaryController.class.getClassLoader().getResourceAsStream("database.properties")) {
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

    private static Connection connect() throws SQLException {
loadDatabaseProperties();
        
        String url, user, password;
        
        // Try to get from properties file first
        if (dbProperties != null && !dbProperties.isEmpty()) {
            url = dbProperties.getProperty("db.url");
            user = dbProperties.getProperty("db.username");
            password = dbProperties.getProperty("db.password");
            System.out.println("Using database properties from file");
        } else {
            // Fallback to environment variables
            url = System.getenv("DB_URL");
            user = System.getenv("DB_USERNAME");
            password = System.getenv("DB_PASSWORD");
            System.out.println("Using database properties from environment variables");
        }
 
        if (url == null || url.trim().isEmpty()) {
            url = "jdbc:postgresql://localhost:5432/click_and_buy";
            System.out.println("Using default database URL");
        }
        
        if (user == null || password == null) {
            throw new SQLException("Database credentials not found in properties file or environment variables");
        }
        
        return DriverManager.getConnection(url, user, password);
        

    }

    private ObservableList<User> getAllUsers() {
        ObservableList<User> userList = FXCollections.observableArrayList();
        String query = "SELECT * FROM user_table;";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String userfName = rs.getString("first_name");
                String userlName = rs.getString("last_name");
                int userPoints = rs.getInt("reward_points");

                userList.add(new User(userId, userfName, userlName, userPoints));
            }
        } catch (Exception e) {
            System.err.println("Error retrieving users: " + e.getMessage());
            e.printStackTrace();
        }

        FilteredList<User> filteredData = new FilteredList<>(userList, p -> true);
        filteredData.predicateProperty().bind(Bindings.createObjectBinding(() -> 
        {
            String searchText = searchField.getText();
            if (searchText == null || searchText.isEmpty()) {
                return user -> true;
            }
            String lowerCaseFilter = searchText.toLowerCase();
            return user -> user.getFname().toLowerCase().contains(lowerCaseFilter) || 
                          user.getLname().toLowerCase().contains(lowerCaseFilter);
        }, searchField.textProperty()));
        
        return filteredData;
    }

    @FXML
    void deleteUser(ActionEvent event) {
        User selectedUser = tableView.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            System.err.println("Please select a user to delete.");
            return;
        }
        
        String query = "DELETE FROM user_table WHERE user_id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, selectedUser.getUserId());
            pstmt.executeUpdate();
            System.out.println("User deleted successfully.");
            refreshTable();
        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }

    @FXML
    void insertUser(ActionEvent event) {
        System.out.println("InsertUser() called");

        String newFName = fNameField.getText();
        String newLName = lNameField.getText();
        String pointsText = pointsField.getText();

        // Validate first name
        if (newFName == null || newFName.trim().isEmpty()) {
            System.err.println("Error: First name cannot be empty");
            return;
        }

        // Validate last name
        if (newLName == null || newLName.trim().isEmpty()) {
            System.err.println("Error: Last name cannot be empty");
            return;
        }

        // Validate points field
        if (pointsText == null || pointsText.trim().isEmpty() || pointsText.equals("Reward Points")) {
            System.err.println("Error: Please enter a valid number for reward points");
            return;
        }
        
        int newPoints;
        try {
            newPoints = Integer.valueOf(pointsText.trim());
            if (newPoints < 0) {
                System.err.println("Error: Reward points cannot be negative");
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: '" + pointsText + "' is not a valid number for reward points");
            return;
        }

        String query = "INSERT INTO user_table (username, user_email, first_name, last_name, phone_number, reward_points) VALUES (?, ?, ?, ?, ?, ?);";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newFName + "." + newLName);
            pstmt.setString(2, "");
            pstmt.setString(3, newFName);
            pstmt.setString(4, newLName);
            pstmt.setString(5, "");
            pstmt.setInt(6, newPoints);
            pstmt.executeUpdate();
            
            System.out.println("User inserted successfully.");
            
            // Clear fields after successful insert
            fNameField.clear();
            lNameField.clear();
            pointsField.clear();
            
            refreshTable();
        } catch (SQLException e) {
            System.err.println("Error inserting user: " + e.getMessage());
        }
    }

    @FXML
    void readUser(ActionEvent event) {
        User selectedUser = tableView.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            System.err.println("Please select a user first.");
            return;
        }
        
        fNameField.setText(selectedUser.getFname());
        lNameField.setText(selectedUser.getLname());
        pointsField.setText(String.valueOf(selectedUser.getPoints()));
        
        System.out.println("User data loaded into fields.");
    }

    @FXML
    void updateUser(ActionEvent event) {
        User selectedUser = tableView.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            System.err.println("Please select a user first.");
            return;
        }

        String newFName = fNameField.getText();
        String newLName = lNameField.getText();
        String pointsText = pointsField.getText();

        // Validate first name
        if (newFName == null || newFName.trim().isEmpty()) {
            System.err.println("Error: First name cannot be empty");
            return;
        }

        // Validate last name
        if (newLName == null || newLName.trim().isEmpty()) {
            System.err.println("Error: Last name cannot be empty");
            return;
        }

        // Validate points field
        if (pointsText == null || pointsText.trim().isEmpty() || pointsText.equals("Reward Points")) {
            System.err.println("Error: Please enter a valid number for reward points");
            return;
        }
        
        int newPoints;
        try {
            newPoints = Integer.valueOf(pointsText.trim());
            if (newPoints < 0) {
                System.err.println("Error: Reward points cannot be negative");
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: '" + pointsText + "' is not a valid number for reward points");
            return;
        }

        String query = "UPDATE user_table SET first_name = ?, last_name = ?, reward_points = ? WHERE user_id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newFName);
            pstmt.setString(2, newLName);
            pstmt.setInt(3, newPoints);
            pstmt.setInt(4, selectedUser.getUserId());
            pstmt.executeUpdate();
            
            System.out.println("User updated successfully.");
            refreshTable();

        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
    }
}