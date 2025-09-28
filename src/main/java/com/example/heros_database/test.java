package com.example.heros_database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Gson gson = new Gson();

        InputStream inputStream = test.class.getResourceAsStream("/users.json");

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
