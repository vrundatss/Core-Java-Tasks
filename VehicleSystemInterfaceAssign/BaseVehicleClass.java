package com.tss.VehicleSystemInterfaceAssign;

import java.util.Random;

public abstract class BaseVehicleClass implements Vehicle {

        protected int id;
        protected String brand;
        protected double price;
        protected int speed;
        protected boolean isStarted;
        protected String type;

        Random random = new Random();
        public BaseVehicleClass(String brand, Double price, int speed) {
            this.id = 10 + random.nextInt(90);
            this.brand = brand;
            this.price = price;
            this.speed = speed;
            this.isStarted = false;
        }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void displayVehicleDetails() {
        System.out.println("---------------------------------------------");
        System.out.println("Vehicle ID: " + id);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("---------------------------------------------");

    }

}
