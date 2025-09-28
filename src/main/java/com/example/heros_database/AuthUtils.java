package com.example.heros_database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import java.util.Optional;


public class AuthUtils {

    public List<User> Users;

    public AuthUtils(){
        this.Users = new ArrayList<>();
        loadUsersFromJson("/users.json");

    }

    public void loadUsersFromJson(String resourcePath){

        Gson gson = new Gson();

        InputStream inputStream = AuthUtils.class.getResourceAsStream(resourcePath);

        Type userListType = new TypeToken<List<User>>() {}.getType();

        try(Reader reader = new InputStreamReader(inputStream)){
            this.Users = gson.fromJson(reader, userListType);
        }
        catch (IOException e){
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
