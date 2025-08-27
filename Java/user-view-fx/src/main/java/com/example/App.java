package com.example;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        TextArea userTextArea = new TextArea();
        userTextArea.setEditable(false);
        userTextArea.setMinWidth(640);
        userTextArea.setMinHeight(400);

        TableView<User> userTableView = new TableView<>();
        userTableView.setMinWidth(640);
        userTableView.setMinHeight(400);

        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
        errorLabel.setFont(new Font(16));

        TableColumn<User, Integer> userIdColumn = new TableColumn<>("Costumer ID");
        TableColumn<User, String> userFirstName = new TableColumn<>("First Name");
        TableColumn<User, String> userLasttName = new TableColumn<>("Last Name");
        TableColumn<User, String> userEmail = new TableColumn<>("Email");

        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        userFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        userLasttName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        userEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        userTableView.getColumns().add(userIdColumn);
        userTableView.getColumns().add(userFirstName);
        userTableView.getColumns().add(userLasttName);
        userTableView.getColumns().add(userEmail);



        DatabaseHandler dbHandler = new DatabaseHandler();
        String userData = "";

        ObservableList<User> customerList = null;


        try {
            userData = dbHandler.getAllUsers();
            customerList = dbHandler.getUsersAsObservableList();
        } catch (SQLException e) {
            errorLabel.setText("Error fetching user data: " + e.getMessage());
            e.printStackTrace();
        }
        if (!userData.isEmpty()) {
            userTextArea.setText(userData);
            userTableView.setItems(customerList);
        }
        VBox verticalBox = new VBox(errorLabel, userTextArea, userTableView);
        scene = new Scene(verticalBox, 640, 480);
        stage.setTitle("Customer data viewer");
        stage.setScene(scene);
        stage.show();

    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}