package com.example.heros_database;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class kjsnkjhs extends Application {
    @Override
    public void start(Stage primaryStage){
        // Create UI elements
        Label welcomeLabel = new Label("Welcome to my JavaFX App!");
        Button clickMeButton = new Button("Click Me!");

        // Create a layout container
        VBox root = new VBox(10); // 10 pixels spacing
        root.getChildren().addAll(welcomeLabel, clickMeButton);

        // Create a scene and set it on the stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("No FXML App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
