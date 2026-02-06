package com.tss.VehicleSystemInterfaceAssign;

public class EVCar extends BaseVehicleClass implements ElectricVehicle{

    public EVCar(String brand, Double price, int speed) {
        super(brand, price, speed);
    }

    @Override
    public void start() {
        if (isStarted){
            System.out.println("EV Car id already started...");
        }else {
            System.out.println("EV Car is Starting...");
        }
    }

    @Override
    public void stop() {
        if(!isStarted){
            System.out.println("EV Car is already stopped...");
        }else{
            System.out.println("EV Car is Stopping...");
        }
    }

    @Override
    public void horn() {
        if (isStarted){
            System.out.println("EV Car horns...");
        }else {
            System.out.println("EV Car is stopped...Please start the EV car first...");
        }
    }

    @Override
    public void playMusic() {
        if(isStarted){
            System.out.println("Playing music in EV car...");
        }
        else {
            System.out.println("EV Car is stopped...Please start the EV car first...");
        }
    }

    @Override
    public void chargeBattery() {
        System.out.println("Charging battery of EV Car");
    }
}
