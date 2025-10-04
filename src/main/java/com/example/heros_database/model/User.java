package com.example.heros_database.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {


    private String user;

    private String password;

    private String status;

    public User(){}

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {return status; }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {this.status = status; }

}
