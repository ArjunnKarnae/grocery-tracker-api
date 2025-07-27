package com.grocerytracker.dto;

import java.util.Date;

public class GroceryItem {

    public GroceryItem() {
    }

    public GroceryItem(String name, int quantity, Date expirationDate, String category, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.category = category;
        this.unit = unit;
    }

    private String id;
    private String name;
    private int quantity;
    private Date expirationDate;
    private String category;
    private String unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                ", category='" + category + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
