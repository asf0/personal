package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        loadPrimaryView();
        stage.setScene(scene);
        stage.setTitle("Primary View");
        stage.show();

    }

    public static void setRoot(String view) throws IOException {
        if (view.equals("secondary")) {
            loadSecondaryView();
        } else {
            loadPrimaryView();
        }
    }
    private static void loadPrimaryView() {
        Label primaryLabel = new Label("This is the Primary View");
        Button primaryButton = new Button("Switch to Secondary View");

        primaryButton.setOnAction(PrimaryEventHandler.getPrimaryButtonHandler());

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(primaryLabel, primaryButton);
        if (scene == null) {
            scene = new Scene(vbox, 640, 480);
        } else {
            scene.setRoot(vbox);
        }
    }

    private static void loadSecondaryView() {
        Label secondaryLabel = new Label("This is the Secondary View");
        Button secondaryButton = new Button("Switch to Primary View");

        secondaryButton.setOnAction(PrimaryEventHandler.getSecondaryButtonHandler());

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(secondaryLabel, secondaryButton);
        if (scene == null) {
            scene = new Scene(vbox, 640, 480);
        } else {
            scene.setRoot(vbox);
        }
    }

    public static void main(String[] args) {
       launch();
    }
}

