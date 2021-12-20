package com.example.techshop;

import java.util.Date;

public class oop_technics_ordered {
    int number, quantity, cost;
    String name, mark, manufacturer;
    Date date;

    public oop_technics_ordered(int number, String name, String mark, String manufacturer, int quantity, int cost, Date date) {
        this.number = number;
        this.quantity = quantity;
        this.cost = cost;
        this.name = name;
        this.mark = mark;
        this.manufacturer = manufacturer;
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Date getDate() {
        return date;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
