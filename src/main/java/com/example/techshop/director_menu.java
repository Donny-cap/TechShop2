package com.example.techshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class director_menu {
    @FXML
    void exit(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("login_menu.fxml");
    }

    @FXML
    void list_of_tech(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("d_list_of_tech.fxml");
    }

    @FXML
    void sold_tech(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("d_sold_tech.fxml");
    }

    @FXML
    void stock_of_tech(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("d_stock_of_tech.fxml");
    }
}
