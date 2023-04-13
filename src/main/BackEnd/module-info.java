module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens Controller to javafx.fxml;
    exports Controller;
    exports BusinessLogic;
    opens BusinessLogic to javafx.fxml;
}