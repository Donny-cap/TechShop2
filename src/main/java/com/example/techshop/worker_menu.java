package com.example.techshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class worker_menu {

    @FXML
    void delete_tech() throws IOException {
        Main m = new Main();
        m.changeScene("w_delete_tech.fxml");
    }

    @FXML
    void exit() throws IOException {
        Main m = new Main();
        m.changeScene("login_menu.fxml");
    }

    @FXML
    void list_of_tech() throws IOException {
        Main m = new Main();
        m.changeScene("w_list_of_tech.fxml");
    }

    @FXML
    void order_tech() throws IOException {
        Main m = new Main();
        m.changeScene("w_order_tech.fxml");
    }

    @FXML
    void ordered_tech() throws IOException {
        Main m = new Main();
        m.changeScene("w_ordered_tech.fxml");
    }

    @FXML
    void out_of_stock_tech() throws IOException {
        Main m = new Main();
        m.changeScene("w_out_of_stock.fxml");
    }

    @FXML
    void sold_tech() throws IOException {
        Main m = new Main();
        m.changeScene("w_sold_tech.fxml");
    }

    @FXML
    void search_of_tech() throws IOException {
        Main m = new Main();
        m.changeScene("w_search_tech.fxml");
    }

}
