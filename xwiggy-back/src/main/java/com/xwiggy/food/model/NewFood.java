package com.xwiggy.food.model;

public class NewFood {

   private String id;
   private String name;
   private int price;
   private int quantityAvailable;
   private String fileDataF;

   public NewFood(){}

    public NewFood(String id, String name, int price, int quantityAvailable, String fileDataF) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.fileDataF = fileDataF;
    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getFileDataF() {
        return fileDataF;
    }

    public void setFileDataF(String fileDataF) {
        this.fileDataF = fileDataF;
    }

    @Override
    public String toString() {
        return "NewFood{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantityAvailable=" + quantityAvailable +
                ", fileDataF=" + fileDataF +
                '}';
    }
}
