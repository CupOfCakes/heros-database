package com.example.heros_database;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;

public class login_screen extends Application {

    @Override
    public void start(Stage primaryStage){
        // Create a layout container
        BorderPane root = new BorderPane();

        //background image
        URL bg_img_url = getClass().getResource("/imgs/temp_login_img.png");
        assert bg_img_url != null;
        Image bg_img =new Image(bg_img_url.toExternalForm());

        BackgroundImage bg = new BackgroundImage(
                bg_img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,

                new BackgroundSize(
                        BackgroundSize.AUTO, BackgroundSize.AUTO,
                        false, false, true,true
                )
        );

        root.setBackground(new Background(bg));

        //background for textboxs
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: rgba(0,0,0,0.6); -fx-padding: 20; -fx-background-radius: 10;");

        //textboxs
        TextField username = new TextField();
        username.setPromptText("Username");
        username.setPrefWidth(200);

        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        password.setPrefWidth(200);

        //add textboxs in background for them
        vbox.getChildren().addAll(username,password);

        //centralize on painel
        root.setBottom(vbox);
        BorderPane.setAlignment(vbox, Pos.CENTER);

        // Create a scene
        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setTitle("Login Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
