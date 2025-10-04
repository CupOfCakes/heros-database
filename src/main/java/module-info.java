module com.example.heros_database {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires jdk.jshell;


    opens com.example.heros_database to javafx.fxml;
    exports com.example.heros_database;
    exports com.example.heros_database.service;
    opens com.example.heros_database.service to javafx.fxml;
    exports com.example.heros_database.model;
    opens com.example.heros_database.model to javafx.fxml;

}