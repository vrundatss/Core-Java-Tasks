package com.tss.VehicleSystemInterfaceAssign;

public class Bike extends BaseVehicleClass implements NonElectricVehicle{

    public Bike(String brand, Double price, int speed) {
        super(brand, price, speed);
    }

    @Override
    public void start() {
        if (isStarted){
            System.out.println("Bike id already started...");
        }else {
            System.out.println("Bike is Starting...");
        }
    }

    @Override
    public void stop() {
        if(!isStarted){
            System.out.println("Bike is already stopped...");
        }else{
            System.out.println("Bike is Stopping...");
        }
    }

    @Override
    public void horn() {
        if (isStarted){
            System.out.println("Bike horns...");
        }else {
            System.out.println("Bike is stopped...Please start the bike first...");
        }
    }

    @Override
    public void getFuelStatus() {
        System.out.println("Getting fuel status of Bike...");
    }
}
