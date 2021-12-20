package com.example.techshop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class connectionsql {
    public static void main(String[] args) throws Exception {
        autorization();
        getConnection();
    }

    public static void autorization(){
        try {
            Connection con = getConnection();
            assert con != null;
            Statement create = con.createStatement();
            ResultSet data = create.executeQuery("SELECT * FROM `techshop`.users where password = '';");

            while (data.next()) {
                String name = data.getString("user_name");
                System.out.println(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Mission Completed");
        }

    }

    public static Connection getConnection(){
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/techshop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "";
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static ObservableList<oop_technics> getData_technics() {
        Connection conn = getConnection();
        ObservableList<oop_technics> list = FXCollections.observableArrayList();
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("select * from `techshop`.technics");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new oop_technics(rs.getInt("id"), rs.getString("name"), rs.getString("mark"), rs.getString("manufacturer"), rs.getInt("quantity"), rs.getInt("cost")));
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static ObservableList<oop_technics_sold> getData_technics_sold() {
        Connection conn = getConnection();
        ObservableList<oop_technics_sold> list = FXCollections.observableArrayList();
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("select * from `techshop`.`technics_sold`");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new oop_technics_sold(rs.getInt("id"), rs.getString("name"), rs.getString("mark"), rs.getString("manufacturer"), rs.getInt("quantity"), rs.getInt("cost"), rs.getDate("date")));
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static ObservableList<oop_technics_ordered> getData_technics_ordered() {
        Connection conn = getConnection();
        ObservableList<oop_technics_ordered> list = FXCollections.observableArrayList();
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("select * from `techshop`.`ordered_tech`");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new oop_technics_ordered(rs.getInt("id"), rs.getString("name"), rs.getString("mark"), rs.getString("manufacturer"), rs.getInt("quantity"), rs.getInt("cost"), rs.getDate("date")));
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
