package com.example.techshop;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.ResourceBundle;

import static com.example.techshop.connectionsql.getConnection;

public class w_order_tech implements Initializable {
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
    private Label error_label;

    @FXML
    private TextField id_tech;

    @FXML
    private TextField quantity;

    @FXML
    void back() throws IOException {
        Main m = new Main();
        m.changeScene("worker_menu.fxml");
    }


    @FXML

    boolean isNumeric(String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    @FXML
    void order() throws SQLException {
        error_label.setText("");
        Connection conn = getConnection();
        assert conn != null;
        PreparedStatement ps = conn.prepareStatement("select `id` from `techshop`.technics");
        ResultSet rs = ps.executeQuery();

        HashSet<String> list = new HashSet<>();

        while (rs.next()){
            list.add(rs.getString("id"));
        }


        if(!(isNumeric(quantity.getText()))){
            error_label.setText("Invalid data type");
            return;
        }

        if(list.contains(id_tech.getText())){

            LocalDate d = LocalDate.now(); // Gets the current date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = d.format(formatter);

            ps = conn.prepareStatement("select * from `techshop`.technics WHERE `id` = '" + id_tech.getText() + "'");
            rs = ps.executeQuery();

            while (rs.next()){
                PreparedStatement ps1 = conn.prepareStatement("INSERT INTO `ordered_tech`(`name`, `manufacturer`, `mark`, `quantity`, `cost`, `date`) VALUES ('" + rs.getString("name") + "','" + rs.getString("manufacturer") + "','" + rs.getString("mark") + "','" + quantity.getText() + "','" + rs.getString("cost") + "','" + date + "')");
                ps1.execute();
            }
            error_label.setText("Success");
            id_tech.setText("");
            quantity.setText("");


            rs.close();
            ps.close();
            conn.close();

        }else{
            error_label.setText("There is no such id");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            UpdateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
