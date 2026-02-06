package com.tss.VehicleSystemInterfaceAssign;

public interface NonElectricVehicle extends Vehicle{
    @Override
    default void getFuelStatus() {
        Vehicle.super.getFuelStatus();
    }
}
