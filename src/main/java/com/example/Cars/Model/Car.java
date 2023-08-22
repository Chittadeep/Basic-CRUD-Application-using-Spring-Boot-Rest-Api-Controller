package com.example.Cars.Model;

public class Car {
    String model;
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    String number;
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    int mileage;
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    double price;
    
    public Car(String model, String number, int mileage, double price) {
        this.model = model;
        this.number = number;
        this.mileage = mileage;
        this.price = price;
    }

    public Car(){}

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
