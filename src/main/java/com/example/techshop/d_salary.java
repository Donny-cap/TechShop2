package com.example.techshop;

import javafx.fxml.FXML;

import java.io.IOException;

public class d_salary {

    @FXML
    void back() throws IOException {
        Main m = new Main();
        m.changeScene("delivery_menu.fxml");
    }

}