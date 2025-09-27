module com.example.heros_database {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens com.example.heros_database to javafx.fxml;
    exports com.example.heros_database;

}