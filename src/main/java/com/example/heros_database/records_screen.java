package com.example.heros_database;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class records_screen extends Application {

    @Override
    public void start(Stage primaryStage){
        BorderPane root = new BorderPane();

        //search
        VBox vbox = new VBox(10);

        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: rgba(0,0,0,0.6); -fx-padding: 20; -fx-background-radius: 10;");

        TextField searchField = new TextField();
        searchField.setPromptText("Search");

        vbox.getChildren().add(searchField);
        vbox.setAlignment(Pos.CENTER);

        root.setTop(vbox);

        //names

        String path = "/jsons/users.json";




    }

}
