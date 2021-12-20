module com.example.techshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.techshop to javafx.fxml;
    exports com.example.techshop;
}