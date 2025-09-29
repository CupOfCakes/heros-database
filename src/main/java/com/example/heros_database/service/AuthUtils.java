package com.example.heros_database.service;

import com.example.heros_database.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;


public class AuthUtils {

    public List<User> Users;

    public AuthUtils(){
        this.Users = new ArrayList<>();
        loadUsersFromJson("/jsons/users.json");

    }

    public void loadUsersFromJson(String resourcePath){

        ObjectMapper mapper = new ObjectMapper();


        try{
            List<User> users = mapper.readValue(
                    new File("src/main/resources/jsons/users.json"),
                    new TypeReference<List<User>>(){}
            );

            this.Users = users;

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Optional<User> authenticate(String username, String password){
        return Users.stream().
                filter(User -> User.getUser() != null && User.getUser().equals(username) &&
                                    User.getPassword() != null && User.getPassword().equals(password))
                .findFirst();
    }


}
