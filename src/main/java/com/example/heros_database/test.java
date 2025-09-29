package com.example.heros_database;

import com.example.heros_database.model.User;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class test {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try{
            List<User> users = mapper.readValue(
                    new File("src/main/resources/jsons/users.json"),
                    new TypeReference<List<User>>(){}
            );

            for(User user:users){
                System.out.println("Username: " + user.getUser());
                System.out.println("Password: " + user.getPassword());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }














        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        InputStream inputStream = test.class.getResourceAsStream("/jsons/users.json");

        if (inputStream == null) {
            System.out.println("Arquivo Users.json não encontrado nos resources!");
            return;
        }

        Type userListType = new TypeToken<List<User>>() {}.getType();



        try(Reader reader = new InputStreamReader(inputStream);){
            //User user = gson.fromJson(reader, User.class);
            List<User> users = gson.fromJson(reader, userListType);
            System.out.println(users);
            for (User user : users) {
                System.out.println("Username: " + user.getUser());
                System.out.println("Password: " + user.getPassword());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
