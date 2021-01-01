package com.guy.tentaofgo.models;

public class CalcProd {

    private String productName;
    private float amountInMeters;
    private float discount;
    private float totalPrice;
    private float totalAmount;

    public CalcProd(String productName, float amountInMeters, float discount, float totalPrice, float totalAmount) {
        this.productName = productName;
        this.amountInMeters = amountInMeters;
        this.discount = discount;
        this.totalPrice = totalPrice;
        this.totalAmount = totalAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getAmountInMeters() {
        return amountInMeters;
    }

    public void setAmountInMeters(float amountInMeters) {
        this.amountInMeters = amountInMeters;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "CalcProd{" +
                "productName='" + productName + '\'' +
                ", amountInMeters=" + amountInMeters +
                ", discount=" + discount +
                ", totalPrice=" + totalPrice +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
