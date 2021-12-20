package com.example.techshop;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class w_delete_tech implements Initializable {
    @FXML
    private TableColumn<oop_technics_ordered, Integer> col_cost;

    @FXML
    private TableColumn<oop_technics_ordered, Date> col_date;

    @FXML
    private TableColumn<oop_technics_ordered, String> col_manufacturer;

    @FXML
    private TableColumn<oop_technics_ordered, String> col_mark;

    @FXML
    private TableColumn<oop_technics_ordered, String> col_name;

    @FXML
    private TableColumn<oop_technics_ordered, Integer> col_num;

    @FXML
    private TableColumn<oop_technics_ordered, Integer> col_quantity;

    @FXML
    private TableView<oop_technics_ordered> table_tech;

    @FXML
    void back() throws IOException {
        Main m = new Main();
        m.changeScene("worker_menu.fxml");
    }

    @FXML
    void delete() {

    }

    ObservableList<oop_technics_ordered> listM;
    public void UpdateTable() {
        col_num.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        col_manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        listM = connectionsql.getData_technics_ordered();
        table_tech.setItems(listM);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UpdateTable();
    }
}
