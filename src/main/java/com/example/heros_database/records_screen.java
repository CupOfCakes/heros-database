package com.example.heros_database;

import com.example.heros_database.model.Char;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jdk.jshell.execution.Util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class records_screen extends Application {




    @Override
    public void start(Stage primaryStage){
        helper hp =  new helper();

        List<Char> listCharacters = hp.loadCharacters();

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #black;");

        //search
        VBox vbox = new VBox(10);

        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: rgba(0,0,0,0.6); -fx-padding: 20; -fx-background-radius: 10;");

        TextField searchField = new TextField();
        searchField.setPromptText("Search");

        vbox.getChildren().add(searchField);

        root.setTop(vbox);

        //names list
        VBox names = new VBox(10);

        for(Char c : listCharacters){
            Label label = new Label(c.getName());
            label.setTextFill(Color.RED);
            label.setStyle("-fx-underline: true; -fx-cursor: hand");

            label.setOnMouseClicked(e -> {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle(c.getName());
                alerta.setHeaderText("Descrição do Monstro");
                alerta.setContentText(c.getDescription());
                alerta.showAndWait();
            });

            names.getChildren().add(label);

        }

        ScrollPane scroll = new ScrollPane(names);
        scroll.setFitToWidth(true);
        scroll.setStyle("-fx-background: black; -fx-control-inner-background: black;");
        root.setCenter(scroll);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Catálogo de Monstros");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
