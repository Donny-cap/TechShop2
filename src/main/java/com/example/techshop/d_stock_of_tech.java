package com.example.techshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class d_stock_of_tech implements Initializable {
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

    @FXML
    void max_quantity() throws SQLException {
        col_num.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        col_manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        ObservableList<oop_technics> list = FXCollections.observableArrayList();

        Connection con = connectionsql.getConnection();
        assert con != null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM `techshop`.technics order by (`quantity` + 0) desc;");
        while (rs.next()) {
            list.add(new oop_technics(rs.getInt("id"), rs.getString("name"), rs.getString("mark"), rs.getString("manufacturer"), rs.getInt("quantity"), rs.getInt("cost")));
        }
        table_tech.setItems(list);
    }

    @FXML
    void min_quantity() throws SQLException {
        col_num.setCellValueFactory(new PropertyValueFactory<>("number"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        col_manufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        ObservableList<oop_technics> list = FXCollections.observableArrayList();

        Connection con = connectionsql.getConnection();
        assert con != null;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM `techshop`.technics order by (`quantity` + 0);");
        while (rs.next()) {
            list.add(new oop_technics(rs.getInt("id"), rs.getString("name"), rs.getString("mark"), rs.getString("manufacturer"), rs.getInt("quantity"), rs.getInt("cost")));
        }
        table_tech.setItems(list);
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

    public void UpdateTable() {
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
