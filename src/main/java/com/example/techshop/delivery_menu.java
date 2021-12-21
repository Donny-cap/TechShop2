package com.example.techshop;

import javafx.fxml.FXML;

import java.io.IOException;

public class delivery_menu {
    @FXML
    void deliver_tech() throws IOException {
        Main m = new Main();
        m.changeScene("d_deliver_tech.fxml");
    }

    @FXML
    void delivered_tech() throws IOException {
        Main m = new Main();
        m.changeScene("d_delivered_tech.fxml");
    }

    @FXML
    void exit() throws IOException {
        Main m = new Main();
        m.changeScene("login_menu.fxml");
    }

    @FXML
    void ordered_tech() throws IOException {
        Main m = new Main();
        m.changeScene("d_ordered_tech.fxml");
    }

    @FXML
    void salary() throws IOException {
        Main m = new Main();
        m.changeScene("d_salary.fxml");
    }
}
