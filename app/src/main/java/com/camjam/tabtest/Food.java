package com.camjam.tabtest;

public class Food {

    protected int uid;
    protected String upc;
    protected String label;
    protected double quantity;
    protected String food_id;
    protected String expirationDate;
    protected String brand;
    protected String foodContentsLabel;
    protected String classification;

    public Food() {

    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getUid() {
        return uid;
    }

    public Food(String upc, String label, double quantity, String food_id, String expirationDate) {
        this.upc = upc;
        this.label = label;
        this.quantity = quantity;
        this.food_id = food_id;
        this.expirationDate = expirationDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFoodContentsLabel() {
        return foodContentsLabel;
    }

    public void setFoodContentsLabel(String foodContentsLabel) {
        this.foodContentsLabel = foodContentsLabel;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Food{" +
                "upc=" + upc +
                ", label='" + label + '\'' +
                ", quantity='" + quantity + '\'' +
                ", food_id='" + food_id + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}