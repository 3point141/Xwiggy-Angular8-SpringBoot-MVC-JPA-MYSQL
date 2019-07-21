package com.xwiggy.food.model;

public class NewCart {

    private int quantity;

    public NewCart(){}

    public NewCart(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "NewCart{" +
                "quantity=" + quantity +
                '}';
    }
}
