package com.tss.VehicleSystemInterfaceAssign;

public class Car extends BaseVehicleClass implements NonElectricVehicle{

    public Car(String brand, double price, int speed) {
        super(brand, price, speed);
    }


    @Override
    public void start() {
        if (isStarted){
            System.out.println("Car id already started...");
        }else {
            System.out.println("Car is Starting...");
        }
    }

    @Override
    public void stop() {
        if(!isStarted){
            System.out.println("Car is already stopped...");
        }else{
            System.out.println("Car is Stopping...");
        }
    }

    @Override
    public void horn() {
        if (isStarted){
            System.out.println("Car horns...");
        }else {
            System.out.println("Car is stopped...Please start the car first...");
        }
    }

    @Override
    public void playMusic() {
        if(isStarted){
            System.out.println("Playing music in car...");
        }
        else {
            System.out.println("Car is stopped...Please start the car first...");
        }
    }

    @Override
    public void getFuelStatus() {
        System.out.println("Getting fuel status of Car...");
    }
}
