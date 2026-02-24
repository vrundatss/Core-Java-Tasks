package com.tss.test;

import java.util.Scanner;

public class ParkingSystem {
    static Scanner scanner = new Scanner(System.in);
    public static final int LIMIT = 10;

    static ParkingLot lots = new ParkingLot(LIMIT);
    static ParkingSlot slot = null;

    public static void main(String[] args) {
//        System.out.println("How many Vehicle do you want to park : ");
//        int numberOfVehicle = scanner.nextInt();

        int choice;
        do{
            System.out.println("==========Parking System==========");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Show all slots details");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Exit");

//            System.out.print("Enter your choice : ");
//            choice = scanner.nextInt();
            choice = readValidInteger("Enter your choice :");

            switch (choice){
                case 1:
                    parkVehicle();
                    break;

                case 2:
                    System.out.println(lots.showSlots());
                    break;

                case 3:
                    removeVehicle();
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter Valid Choice...");
            }

        }while (choice != 4);

    }

    private static void parkVehicle(){
        String name;
        while (true){
            scanner.nextLine();
            System.out.print("Enter Owner Name : ");
            name = scanner.nextLine();
            if(name.matches("[A-Za-z ]+"))
            {
                break;
            }
            else{
                System.out.println("Enter valid String...");
            }
        }

        Vehicle vehicle = new Vehicle(name);
        boolean parked = false;

        for (int i = 1; i < LIMIT; i++) {
            slot = lots.findSlot(i);

            if(slot != null && slot.isFree()){
                lots.park( slot.getSlotNumber() , vehicle);
                parked = true;
                break;
            }
        }
        if (!parked) {
            System.out.println("No free slots available...Parking is Full...");
        }
    }

    private static void removeVehicle(){
        System.out.print("Enter Vehicle Number : ");
        int number  = scanner.nextInt();

        boolean found = false;

        for (int i = 1; i < LIMIT; i++) {
            slot = lots.findSlot(i);
            if (slot!= null && !slot.isFree() && slot.getVehicle().getVehicleNumber() == number) {
                lots.remove(i);
                System.out.println("Vehicle removed from slot : " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Vehicle not found in any slot.");
        }
    }

    private static int readValidInteger(String msg){
        while (true){
            System.out.print(msg);
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num > 0)
                    return num;
                else
                    System.out.println("Enter valid positive number...");

            } else {
                System.out.println("Enter valid number...");
                scanner.nextLine();
            }
        }
    }

}
