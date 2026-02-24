package com.tss.test;

public class ParkingLot {
    ParkingSlot slots[] = null;

    public ParkingLot(int totalSlots){
        this.slots = new ParkingSlot[totalSlots];
        for (int i = 0; i < totalSlots; i++) {
            slots[i] = new ParkingSlot(i);
        }
    }

    public void park(int slotNumber , Vehicle vehicle){
//        ParkingSlot slot = new ParkingSlot(slotNumber);
//        slot.parkVehicle(vehicle);
        if(slotNumber >= 0 && slotNumber < slots.length){
            ParkingSlot slot = slots[slotNumber];
            if(slot.isFree()){
                slot.parkVehicle(vehicle);
            }
            else {
                System.out.println("Slot is already occupied...");
            }
        }
    }

    public void remove(int slotNumber){
//        ParkingSlot slot = new ParkingSlot(slotNumber);
//        slot.removeVehicle();
        if(slotNumber >= 0 && slotNumber < slots.length){
            ParkingSlot slot = slots[slotNumber];
            slot.removeVehicle();
        }
//        return false;
    }

    public StringBuffer showSlots(){
        System.out.println();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i =1 ; i < slots.length; i++){
            if(slots[i].isFree()){
                stringBuffer.append("Slot ").append(i).append(" is Empty.\n").append("\n");
            } else {
                stringBuffer.append("Slot ").append(i).append(" is Occupied by Vehicle ").append(slots[i].toString()).append("\n");
            }
        }
        return stringBuffer;
    }

    public ParkingSlot findSlot(int slotNumber) {
        if (slotNumber >= 0 && slotNumber < slots.length) {
            return slots[slotNumber];
        }
        return null;
    }

//    public ParkingSlot findSlot(int slotNumber){
//
//        if(slotNumber >= 0 &&  slotNumber < slots.length){
//            for (int i =1 ; i < slots.length; i++){
//                if(slots[i].isFree()){
//                    System.out.println("Slot found at slot number : " + slotNumber);
//                    return slots[i];
//                }
//            }
//        }
//        return null;
//    }
}
