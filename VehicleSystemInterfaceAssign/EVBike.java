package com.tss.VehicleSystemInterfaceAssign;

public class EVBike extends BaseVehicleClass implements ElectricVehicle{
    public EVBike(String brand, Double price, int speed) {
        super(brand, price, speed);
    }

    @Override
    public void start() {
        if (isStarted){
            System.out.println("EV Bike id already started...");
        }else {
            System.out.println("EV Car is Starting...");
        }
    }

    @Override
    public void stop() {
        if(!isStarted){
            System.out.println("EV Bike is already stopped...");
        }else{
            System.out.println("EV Bike is Stopping...");
        }
    }

    @Override
    public void horn() {
        if (isStarted){
            System.out.println("EV Bike horns...");
        }else {
            System.out.println("EV Bike is stopped...Please start the EV bike first...");
        }
    }

    @Override
    public void chargeBattery() {
        System.out.println("Charging battery of EV Bike");
    }
}


