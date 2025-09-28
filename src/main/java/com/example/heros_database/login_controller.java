package com.example.heros_database;


import javafx.scene.control.TextField;

public class login_controller {
    private final TextField usernameField;
    private final TextField passwordField;


    public login_controller(TextField usernameField, TextField passwordField) {

        this.usernameField = usernameField;
        this.passwordField = passwordField;

    }

    public boolean authenticate() {
        AuthUtils auth = new AuthUtils();

        String u = usernameField.getText();
        String p = passwordField.getText();

        System.out.println(auth.authenticate(u, p));

        if(auth.authenticate(u, p).isPresent()){
            System.out.println("Welcome "+u);
            return true;
        }
        else{
            System.out.println(u + " " + p);
            return false;
        }
    }
}
