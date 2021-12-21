package com.example.techshop;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import static com.example.techshop.connectionsql.getConnection;

public class d_deliver_tech implements Initializable {
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
        m.changeScene("delivery_menu.fxml");
    }

    @FXML
    void deliver() throws SQLException {

        Connection conn = getConnection();
        assert conn != null;
        PreparedStatement ps = conn.prepareStatement("Select `name`, `mark`, `quantity` from `ordered_tech` WHERE `id` = '" + table_tech.getSelectionModel().getSelectedItem().getNumber() + "'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            System.out.println(true);
            ps = conn.prepareStatement("UPDATE `technics` SET `quantity`=`quantity` + '" + rs.getString("quantity") + "' WHERE `name` = '" + rs.getString("name") + "' and `mark` = '" + rs.getString("mark") + "'");
            ps.execute();
        }

        ps = conn.prepareStatement("DELETE FROM `ordered_tech` WHERE `id` = '" + table_tech.getSelectionModel().getSelectedItem().getNumber() + "'");
        ps.execute();
        rs.close();
        ps.close();
        conn.close();

        UpdateTable();

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
