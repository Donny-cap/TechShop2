package com.example.techshop;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class d_list_of_tech implements Initializable {

    @FXML
    private TableColumn<oop_technics, Integer> col_cost;

    @FXML
    private TableColumn<oop_technics, String> col_manufacturer;

    @FXML
    private TableColumn<oop_technics, String> col_mark;

    @FXML
    private TableColumn<oop_technics, String> col_name;

    @FXML
    private TableColumn<oop_technics, Integer> col_num;

    @FXML
    private TableColumn<oop_technics, Integer> col_quantity;

    @FXML
    private TableView<oop_technics> table_tech;

    @FXML
    void back() throws IOException {
        Main m = new Main();
        m.changeScene("director_menu.fxml");

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            UpdateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ObservableList<oop_technics> listM;

    public void UpdateTable() throws Exception {
        col_num.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        col_manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        listM = connectionsql.getData_technics();
        table_tech.setItems(listM);
    }
}
