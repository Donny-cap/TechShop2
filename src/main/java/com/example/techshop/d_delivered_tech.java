package com.example.techshop;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class d_delivered_tech implements Initializable {
    @FXML
    private TableColumn<oop_technics_delivered, Date> col_date;

    @FXML
    private TableColumn<oop_technics_delivered, String> col_manufacturer;

    @FXML
    private TableColumn<oop_technics_delivered, String> col_name;

    @FXML
    private TableColumn<oop_technics_delivered, Integer> col_num;

    @FXML
    private TableColumn<oop_technics_delivered, Integer> col_quantity;

    @FXML
    private TableView<oop_technics_delivered> table_tech;

    @FXML
    private Label TotalQuantityLabel;

    @FXML
    void back() throws IOException {
        Main m = new Main();
        m.changeScene("delivery_menu.fxml");
    }

    ObservableList<oop_technics_delivered> listM;
    public void UpdateTable() {
        col_num.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        listM = connectionsql.getData_technics_delivered();
        table_tech.setItems(listM);
        int quantity = 0;
        for(oop_technics_delivered d : listM){
            quantity += d.getQuantity();
        }

        TotalQuantityLabel.setText("Total quantity: " + quantity);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UpdateTable();
    }
}
