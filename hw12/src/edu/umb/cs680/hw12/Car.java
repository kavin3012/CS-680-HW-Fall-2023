package edu.umb.cs680.hw12;


public class Car {
    private String make, model;
    private int year, mileage, dominationCount;
    private float price;

    public Car(String make, String model, int year, int mileage, float price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.dominationCount = 0;
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
    public int getDominationCount() {
        return dominationCount;
    }   
    public void setDominationCount(int value) {
        this.dominationCount = value;
    }


}

    