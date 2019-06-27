package com.xwiggy.food.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Food {

    @Id
    private String id;
    private String item;
    private int price;
    private int quantity;

    public Food(){}

    public Food(String id, String item, int price,int quantity) {
        this.id = id;
        this.item = item;
        this.price = price;
        this.quantity=quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
