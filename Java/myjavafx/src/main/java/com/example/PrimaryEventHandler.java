package com.example;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.io.IOException;

public class PrimaryEventHandler {

    public static EventHandler<ActionEvent> getPrimaryButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    App.setRoot("secondary");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static EventHandler<ActionEvent> getSecondaryButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    App.setRoot("primary");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
