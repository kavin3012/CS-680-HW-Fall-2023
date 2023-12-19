package edu.umb.cs680.hw11;


public class Car {
    private String make, model;
    private int year, mileage;
    private float price;

    public Car(String make, String model, int year, int mileage, float price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getMake() {
        return make;
    }


    public String getModel() {
        return model;
    }


    public int getYear() {
        return year;
    }


    public int getMileage() {
        return mileage;
    }


    public float getPrice() {
        return price;
    }


}

    