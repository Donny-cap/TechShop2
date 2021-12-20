package com.example.techshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login_menu {

    @FXML
    private Label wrongLogIn;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    void login(ActionEvent event) throws Exception {
        checkLogin();
//        test();

    }

    private void checkLogin() throws Exception {
        Connection ConnectionDB = connectionsql.getConnection();
        String log = String.valueOf(username.getText());
        String verifyLogin = "SELECT `password`, `username`, `account_type` FROM `techshop`.`users` where `username` = '"+ log +"';";

        assert ConnectionDB != null;
        Statement statement = ConnectionDB.createStatement();
        ResultSet data  = statement.executeQuery(verifyLogin);

        if (data.next()){
            String pas = String.valueOf(password.getText());
            String pasBD = data.getString("password");
            String ac_type = data.getString("account_type");
            Main m = new Main();
            if (pasBD.equals(pas)) {
                wrongLogIn.setText("Success!");
                if(ac_type.equals("director")){
                    m.changeScene("director_menu.fxml");
                }else if(ac_type.equals("worker")){
                    m.changeScene("worker_menu.fxml");
                }else if(ac_type.equals("delivery")){
                    m.changeScene("delivery_menu.fxml");
                }} else { wrongLogIn.setText("Wrong username or password!" ); }

        }else{ wrongLogIn.setText("There is no such username!"); }
    }

    private void test() throws IOException {
        Main m = new Main();
        if(username.getText().equals("director") && password.getText().equals("123")) {
            wrongLogIn.setText("Success!");
            m.changeScene("director_menu.fxml");
        }
        else if(username.getText().equals("supp") && password.getText().equals("123")) {
            wrongLogIn.setText("Success!");
            m.changeScene("fxml/supp_menu.fxml");
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data.");
        }
        else { wrongLogIn.setText("Wrong username or password!");
        }
    }
}