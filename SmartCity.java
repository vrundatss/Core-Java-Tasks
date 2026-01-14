package com.tss.assignments;

import java.util.Scanner;

import static java.lang.System.exit;

public class SmartCity {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        int mainChoice = 0 ;

        do{
            System.out.println("\n============ Smart City System ============");
            System.out.println("1. Electricity Service");
            System.out.println("2. Water Service");
            System.out.println("3. Internet Service");
            System.out.println("4. Exit");

            System.out.print("Enter your choice : ");
            mainChoice = scanner.nextInt();

            switch (mainChoice){
                case 1 :
                    electricityService();
                    break;

                case 2:
                    waterService();
                    break;

                case 3:
                    internetService();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    exit(0);
                    break;

                default:
                    System.out.println("Enter valid choice...");
            }

        }while (mainChoice != 4);
    }

    public static void electricityService(){

        System.out.println("1. Domestic Connection");
        System.out.println("2. Commercial Connection");
        System.out.println("3. Industrial Connection");
        System.out.println("4. Back");

        System.out.print("Enter your choice : ");
        int electricityChoice = scanner.nextInt();

        if(electricityChoice >= 1 && electricityChoice <= 3) {
            System.out.print("Enter Units Consumed : ");
            int units = scanner.nextInt();

            if(units <= 0){
                System.out.println("Enter Positive Units...");
                return;
            }
            double total_bill = 0;
            int fixedCharge = 0;
            String connectionType = " ";
            double rebate = 0 , energyCharge = 0 , extra = 0;

            switch (electricityChoice) {

                case 1:
                    connectionType = "Domestic";
                    fixedCharge = 50;
                    if (units >= 0 && units <= 100) {
                        energyCharge = 2 * units;
                    } else if (units >= 101 && units <= 300) {
                        energyCharge = (100 * 2) + ((units - 100) * 3);
                    } else if (units > 300) {
                        energyCharge = (100 * 2) + (200 * 3) + ((units - 300) * 5);
                    }

                    if(energyCharge > 2000){
                        extra = energyCharge * 0.10;
                        total_bill = energyCharge + extra + fixedCharge;
                    }else {
                        total_bill = energyCharge + fixedCharge;
                    }
                    break;

                case 2:
                    connectionType = "Commercial";
                    fixedCharge = 150;
                    if (units >= 0 && units <= 200) {
                        energyCharge = 5 * units;
                    } else if (units >= 201 && units <= 500) {
                        energyCharge = (200 * 5) + ((units - 200) * 7);
                    } else if (units > 500) {
                        energyCharge = (200 * 5) + (300 * 7) + ((units - 500) * 10);
                    }

                    total_bill = energyCharge + fixedCharge;

                    break;

                case 3:
                    connectionType = "Industrial";
                    fixedCharge = 500;

                    energyCharge = units * 12;

                    if(units > 1000){
                        rebate = energyCharge * 0.15;
                    }

                    total_bill = energyCharge + fixedCharge -  rebate;
                    break;

                case 4:
                    System.out.print("Returning to main menu...");
                    return;

                default:
                    System.out.println("Enter Valid Choice...");
                    return;
            }

                energyCharge = (total_bill - fixedCharge) + rebate;

                System.out.println("\nConnection Type :  " + connectionType);
                System.out.println("Units :  " + units);
                System.out.println("Energy Charge :  " + energyCharge);
                System.out.println("Fixed Charge :  " + fixedCharge);
                System.out.println("Extra :  " + extra);
                System.out.println("Rebate :  " + rebate);
                System.out.println("Total Electricity Bill :  " + total_bill + " Rs.");

        }
    }


    public static void waterService(){
        System.out.println("1. Residential");
        System.out.println("2. Society");
        System.out.println("3. Factory");
        System.out.println("4. Back");

        System.out.print("Enter your choice : ");
        int waterChoice = scanner.nextInt();

        int waterCharge = 0;
        double total_water_bill = 0;

        switch (waterChoice){
            case 1:
                System.out.print("Enter Number of Persons : ");
                int numberOfPersons = scanner.nextInt();
                waterCharge = numberOfPersons * 30;
                break;

            case 2:
                System.out.print("Enter Number of Taps : ");
                int numberOfTaps = scanner.nextInt();
                waterCharge = numberOfTaps * 25;
                break;

            case 3:
                System.out.print("Enter Number of Machines : ");
                int numberOfMachines = scanner.nextInt();
                waterCharge = numberOfMachines * 100;
                break;

            case 4:
                System.out.print("Returning to main menu...");
                return;

            default:
                System.out.print("Enter valid input values...");
                return;
        }

        if(waterCharge > 3000){
            total_water_bill = waterCharge +  (waterCharge * 0.08);
        }
        else {
            total_water_bill = waterCharge;
        }

        System.out.println("Total Water Bill : " + total_water_bill+ " Rs." );
    }

    public static void internetService(){
        System.out.println("1. Student Plan");
        System.out.println("2. Home Plan");
        System.out.println("3. Business Plan");
        System.out.println("4. Back");

        System.out.print("Enter your choice : ");
        int internetChoice = scanner.nextInt();
        int months = 0;
        double internetBill = 0;
        switch (internetChoice) {

            case 1:
                System.out.print("Enter Duration in Months(1, 3 ,6) : ");
                months = scanner.nextInt();

                if (months == 1)
                    internetBill = 299;
                else if (months == 3)
                    internetBill = 799;
                else if (months == 6)
                    internetBill = 1499 - (1499 * 0.05);
                else {
                    System.out.println("Enter months in 1 , 3 , 6 only...");
                    return;
                }
                break;

            case 2:
                System.out.print("Enter Duration in Months(1, 3 ,6) : ");
                months = scanner.nextInt();

                if (months == 1)
                    internetBill = 499;
                else if (months == 3)
                    internetBill = 1399;
                else if (months == 6)
                    internetBill = 2699 - (2699 * 0.05);
                else {
                    System.out.println("Enter months in 1 , 3 , 6 only...");
                    return;
                }
                break;

            case 3:
                System.out.print("Enter Duration in Months(1, 3 ,6) : ");
                months = scanner.nextInt();

                if (months == 1)
                    internetBill = 999;
                else if (months == 3)
                    internetBill = 2799;
                else if (months == 6)
                    internetBill = 5499 - (5499 * 0.05);
                else {
                    System.out.println("Enter months in 1 , 3 , 6 only...");
                    return;
                }
                break;

            case 4:
                System.out.print("Returning to main menu...");
                return;

            default:
                System.out.println("Enter months in 1 , 3 , 6 only...");
                return;
        }
        System.out.println("Total internet Bill : " + internetBill + " Rs." );
    }
}
