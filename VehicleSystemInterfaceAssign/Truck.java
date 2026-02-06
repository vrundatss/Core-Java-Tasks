package com.tss.VehicleSystemInterfaceAssign;

public class Truck extends BaseVehicleClass implements NonElectricVehicle{

    public Truck(String brand, Double price, int speed) {
        super(brand, price, speed);
    }

    @Override
    public void start() {
        if (isStarted){
            System.out.println("Truck id already started...");
        }else {
            System.out.println("Truck is Starting...");
        }
    }

    @Override
    public void stop() {
        if(!isStarted){
            System.out.println("Truck is already stopped...");
        }else{
            System.out.println("Truck is Stopping...");
        }
    }

    @Override
    public void horn() {
        if (isStarted){
            System.out.println("Truck horns...");
        }else {
            System.out.println("Truck is stopped...Please start the Truck first...");
        }
    }

    @Override
    public void getFuelStatus() {
        System.out.println("Getting fuel status of Truck...");
    }
}
