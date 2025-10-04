package com.example.heros_database;

import com.example.heros_database.model.Char;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class data_screen extends Application {

    public String name;

    public final List<Char> characters = new ArrayList<>();


    public data_screen(String name) {
        this.name = name;
    }


    public Char getCharcterByName(String name, List<Char> characters) {
        for (Char c : characters) {
            try{
                String itemName = (String) c.getClass().getMethod("getName").invoke(c);
                if(itemName.equals(name)){
                    return c;
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public void start(Stage primaryStage){
        name = "Sombrius";
        helper hp = new helper();
        List<Char> characters = hp.loadCharacters();

        Char selectChar = getCharcterByName(name, characters);

        System.out.println(selectChar);


        
    }

    public static void main(String[] args) {
        launch(args);

    }
}
