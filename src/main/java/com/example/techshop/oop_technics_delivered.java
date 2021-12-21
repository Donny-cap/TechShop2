package com.example.techshop;

import java.util.Date;

public class oop_technics_delivered {
    int number, quantity;
    String name, manufacturer;
    Date date;

    public oop_technics_delivered(int number, String name, String manufacturer, int quantity, Date date) {
        this.number = number;
        this.quantity = quantity;
        this.name = name;
        this.manufacturer = manufacturer;
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
