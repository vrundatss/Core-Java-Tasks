package com.tss.VehicleSystemInterfaceAssign;

public interface Vehicle {


    void start();
    void stop();

    default void horn(){
        System.out.println("Horn : Not Applicable...");
    }

    default void playMusic(){
        System.out.println("Music : Not Applicable...");
    }

    default void chargeBattery(){
        System.out.println("Not Applicable for Non-Electric Vehicle...");
    }

    default void getFuelStatus(){
        System.out.println("Not Applicable for Electric Vehicle...");
    }

    public static void vehicleInspection(){
        System.out.println("Inspecting Vehicle...");
    }

}
