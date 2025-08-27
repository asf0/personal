package com.example;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Label nameLabel;

    @FXML
    private TextField passwordField;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField userField;

    @FXML
    private Label userLabel;

    private StringProperty userTextProperty = new SimpleStringProperty();
    private StringProperty pwTexyProperty = new SimpleStringProperty();

    @FXML
    public void initialize() {
        userTextProperty.bindBidirectional(userField.textProperty());

        pwTexyProperty.bindBidirectional(passwordField.textProperty());

        userLabel.textProperty().bind(Bindings.createStringBinding(() -> checkAvailability(userTextProperty.get()), userTextProperty));
        passwordLabel.textProperty().bind(Bindings.createStringBinding(() -> checkPasswordStrength(pwTexyProperty.get()), pwTexyProperty));
    }

    private String checkAvailability(String username) {
        ArrayList<String> reserved = new ArrayList<>(Arrays.asList("admin", "manager"));
        if (username == null || username.trim().isEmpty()) {
            return "Username cannot be empty";
        }
        if(reserved.contains(username.toLowerCase())) {
            return "Not Available";
        
        } else {
            return "Available";
        }
    }

    private String checkPasswordStrength(String password) {
     
        int len = password.length();
        String passwordStrength;

        if (len < 4) {
            passwordStrength = "Weak";
        } else if (len < 8) {
            passwordStrength = "Medium";
        } else {
            passwordStrength = "Strong";
        }
        return "Password Strength: " + passwordStrength;
    } 

}
