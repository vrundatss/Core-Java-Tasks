package com.tss.test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Vehicle {
    private int vehicleNumber;
    private String ownerName;

    private static Set<Integer> vehicleNumbersSet = new HashSet<>();

    Random random = new Random();

    public Vehicle(String ownerName) {
        int number;
        do {
            number = 10 + random.nextInt(90);
        } while (vehicleNumbersSet.contains(number));

        vehicleNumbersSet.add(number);
        this.vehicleNumber = number;

        this.ownerName = ownerName;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public String toString(){
        return "\nVehicle Details ==> \nVehicle Number : " + vehicleNumber + "\nOwner Name :" + ownerName + "\n";
    }
}
