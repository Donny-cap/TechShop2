package com.example.techshop;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class w_search_tech implements Initializable {

    @FXML
    private TextField search;

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
        m.changeScene("worker_menu.fxml");
    }

    ObservableList<oop_technics> listM;
    ObservableList<oop_technics> dataList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            UpdateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            search();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    @FXML
    public void search() throws Exception {
        col_num.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        col_manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        dataList = connectionsql.getData_technics();
        table_tech.setItems(dataList);

        FilteredList<oop_technics> filteredData = new FilteredList<>(dataList, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(technics -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();

            if (technics.getName().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            } else if (technics.getManufacturer().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }else if (technics.getMark().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }else if (String.valueOf(technics.getQuantity()).contains(lowerCaseFilter)) {
                return true;
            }else if (String.valueOf(technics.getCost()).contains(lowerCaseFilter)) {
                return true;
            }
            else return String.valueOf(technics.getNumber()).contains(lowerCaseFilter);
        }));
        SortedList<oop_technics> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_tech.comparatorProperty());
        table_tech.setItems(sortedData);
    }
}
