package com.grocerytracker.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "groceryitems")
public class GroceryItemEntity {

    @Id
    @Field(name = "grocery_item_id")
    private ObjectId id;

    @Field(name = "grocery_item_name")
    private String name;

    @Field(name = "grocery_item_quantity")
    private int quantity;

    @Field(name = "grocery_item_expiration_date")
    private Date expirationDate;

    @Field(name = "grocery_item_category")
    private String category;

    @Field(name = "grocery_item_unit")
    private String unit;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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
        return "GroceryItemEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                ", category='" + category + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
