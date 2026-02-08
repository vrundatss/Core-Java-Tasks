package com.tss.VehicleSystemInterfaceAssign;

import com.tss.AccountCollectionAssign.UtilityAccountMethods;

import java.util.Scanner;

public class VehicleManagementSystemMain {
    static Scanner scanner = new Scanner(System.in);

    public static final int MAX_VEHICLES = 20;
    static int vehicleCount = 0;

    static BaseVehicleClass[] vehicles = new BaseVehicleClass[MAX_VEHICLES];

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n============ Insurance MANAGEMENT SYSTEM ============");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Start Vehicle");
            System.out.println("3. Stop Vehicle");
            System.out.println("4. Get Fuel Status for Non-Electric Vehicle");
            System.out.println("5. Charge Battery for Electric Vehicle");
            System.out.println("6. Play Horn");
            System.out.println("7. Play Music");
            System.out.println("8. Perform Vehicle Inspection");
            System.out.println("9. Display All Vehicles");
            System.out.println("10. Exit");

            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();

            Vehicle vehicle;

            switch (choice) {
                case 1:
                    addVehicle();
                    break;

                case 2:
                    vehicle = findVehicle();
                    vehicle.start();
                    break;

                case 3:
                    vehicle = findVehicle();
                    vehicle.stop();
                    break;

                case 4:
                    vehicle = findVehicle();
                    vehicle.getFuelStatus();
                    break;

                case 5:
                    vehicle = findVehicle();
                    vehicle.chargeBattery();
                    break;

                case 6:
                    vehicle = findVehicle();
                    vehicle.horn();
                    break;

                case 7:
                    vehicle = findVehicle();
                    vehicle.playMusic();
                    break;

                case 8:
                    Vehicle.vehicleInspection();
                    break;

                case 9:
                    for (int i = 0; i < vehicleCount; i++) {
                        if (vehicles[i] != null) {
                         vehicles[i].displayVehicleDetails();
                        }
                    }
                    break;

                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter valid choice (1 to 9)!");
                    break;
            }

        }while (choice != 10);
    }

    private static void addVehicle() {
        if (vehicleCount >= MAX_VEHICLES) {
            System.out.println("Vehicle limit reached. Cannot add more Vehicles.");
            return;
        }

        System.out.println("\nChoose Vehicle Type:");
        System.out.println("a. Car ");
        System.out.println("b. Bike ");
        System.out.println("c. Truck ");
        System.out.println("d. Electric Car ");
        System.out.println("e. Electric Bike ");

        String type;
        while (true){
            System.out.print("Enter your choice (a/b/c/d/e): ");

            type = scanner.next().toLowerCase();

            if(!type.equals("a") && !type.equals("b") && !type.equals("c") && !type.equals("d") && !type.equals("e")){
                System.out.println("Invalid choice! Please enter only 'a', 'b','c' , 'd' or 'e'.");
            }
            else {
                break;
            }
        }

        String brand = UtilityAccountMethods.getValidString("Enter Brand: ");

        double price = UtilityAccountMethods.getValidAmount("Enter Price: ");

        System.out.print("Enter Speed: ");
        int speed = UtilityAccountMethods.readPositiveNumber();

        Vehicle vehicle;
        BaseVehicleClass base;

        switch (type) {
            case "a":
                vehicle = new Car(brand , price , speed );
                System.out.println("Car added Successfully!");
                base = (BaseVehicleClass) vehicle;
                base.setType("Car");
                break;

            case "b":
                vehicle = new Bike(brand , price , speed );
                System.out.println("Bike added Successfully!");
                base = (BaseVehicleClass) vehicle;
                base.setType("Bike");
                break;

            case "c":
                vehicle = new Truck(brand , price , speed );
                System.out.println("Truck added Successfully!");
                base = (BaseVehicleClass) vehicle;
                base.setType("Truck");
                break;

            case "d":
                vehicle = new EVCar(brand , price , speed );
                System.out.println("EV Car added Successfully!");
                base = (BaseVehicleClass) vehicle;
                base.setType("EV Car");
                break;

            case "e":
                vehicle = new EVBike(brand , price , speed );
                System.out.println("EV Bike added Successfully!");
                base = (BaseVehicleClass) vehicle;
                base.setType("EV Bike");
                break;

            default:
                System.out.println("Invalid policy type. Returning to main menu...");
                return;
        }

        vehicles[vehicleCount++] = (BaseVehicleClass) vehicle;
        System.out.println("Vehicle added successfully with Vehicle ID: " + ((BaseVehicleClass) vehicle).getId());
    }


    static BaseVehicleClass findVehicle() {
        System.out.print("Enter Vehicle ID: ");
        int number = UtilityAccountMethods.readPositiveNumber();
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i] != null && vehicles[i].getId() == number) {
                return vehicles[i];
            }
        }
        System.out.println("No Policy found with this Policy number " + number);
        return null;
    }
}
