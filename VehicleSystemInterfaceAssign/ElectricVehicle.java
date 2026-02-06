package com.tss.VehicleSystemInterfaceAssign;

public interface ElectricVehicle extends Vehicle{
    @Override
    default void chargeBattery() {
        Vehicle.super.chargeBattery();
    }
}
