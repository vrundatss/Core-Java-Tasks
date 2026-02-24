package com.tss.test;

public class ParkingSlot {

    private int slotNumber;
    private SlotStatus status;
    private Vehicle vehicle;
    private boolean free;

    public ParkingSlot(int slotNumber ) {
        this.slotNumber = slotNumber;
        this.free = true;
        this.vehicle = null;

        if(free)
            status = SlotStatus.FREE;
        else
            status = SlotStatus.OCCUPIED;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle vehicle){
        if(this.free){
            this.vehicle = vehicle;
            this.free = false;
            this.status = SlotStatus.OCCUPIED;
        }
        System.out.println("Vehicle Parked at Parking slot : " + this.getSlotNumber() );
        System.out.println("Your Vehicle Number : " + vehicle.getVehicleNumber());
    }

    public void removeVehicle(){
        if(!this.free){
            this.vehicle = null;
            this.free = true;
            this.status =SlotStatus.FREE;
            System.out.println("\nRemoving Parked Vehicle...");
        }else {
            System.out.println("Slot is already empty...");
        }
    }

    @Override
    public String toString() {
        return "\nSlot Number : " + slotNumber + " Status : " + status + vehicle;
    }

    public boolean isFree() {
        return this.free;
    }
}
