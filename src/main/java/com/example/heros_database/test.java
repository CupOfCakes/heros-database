package com.example.heros_database;

import com.example.heros_database.model.User;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class test extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField searchField = new TextField();
        searchField.setPromptText("busca");

        ObservableList<String> characters = FXCollections.observableArrayList(
                "charcter 1", "charcter2", "charcter3"
        );

        FilteredList<String> filteredCharacters = new FilteredList<>(characters, s -> true);

        ListView<String> listView = new ListView<>(filteredCharacters);

        // Filtrar a lista conforme digita
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredCharacters.setPredicate(character -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                return character.toLowerCase().contains(lowerCaseFilter);
            });
        });

        VBox root = new VBox(10, searchField, listView);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Character Search");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
