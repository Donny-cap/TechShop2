package com.example.techshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class delivery_menu {
    @FXML
    void deliver_tech(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("w_delete_tech.fxml");
    }

    @FXML
    void delivered_tech(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("w_delete_tech.fxml");
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login_menu.fxml");
    }

    @FXML
    void ordered_tech(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("w_delete_tech.fxml");
    }

    @FXML
    void salary(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("w_delete_tech.fxml");
    }
}
