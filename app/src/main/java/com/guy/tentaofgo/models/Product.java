package com.guy.tentaofgo.models;

public class Product {

    private String name;
    private float size;
    private float price;

    public Product(String name, float size, float price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getSize() {
        return size;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}
