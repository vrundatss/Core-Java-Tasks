package com.tss.model;

import java.util.Scanner;

public class StudentProfileApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student student1 =new Student();

        int choice = 0;

         int id = 0;
         String name;
         String course;
         double feesPaid = 0;
         double totalFees = 10000;
         double amount = 0;
         String newCourse ="";

        System.out.print("Enter your id : ");
        String input = "";

        while (true) {
            input = scanner.next();

            if (input.matches("\\d+") && input.length() < 15) {
                id = Integer.parseInt(input);
                if (id > 0) {
                    break;
                } else {
                    System.out.print("Enter valid positive id : ");
                }
            } else {
                System.out.print("Enter valid id (positive digits only): ");
            }
        }
        scanner.nextLine();

        while (true) {
            try {
                System.out.print("Enter your Name : ");
                name = scanner.nextLine();
                student1.setName(name);
                break;

            }  catch (Exception e) {
                System.out.println("Please enter a valid name.");
            }
        }

//        scanner.nextLine();

        while (true) {
            try {
                System.out.print("Enter your Course : ");
                course = scanner.next();
                student1.setCourse(course);
                break;

            }  catch (Exception e) {
                System.out.println("Please enter a valid name.");
            }
        }

        scanner.nextLine();
        System.out.print("Enter Fees paid : ");
        while (true) {
            feesPaid = scanner.nextDouble();
            if (feesPaid >= 0 && feesPaid <= 1000000 && feesPaid <= totalFees) {
                break;
            }
            System.out.print("Enter valid fees : ");
        }

        System.out.print("Enter Total fees : ");
        while (true) {
            totalFees = scanner.nextDouble();
            if (totalFees >= 0 && totalFees >= feesPaid && totalFees <= 1000000) {
                break;
            }
            System.out.print("Enter valid total fees : ");
        }

        student1 = new Student(id , name , course , feesPaid ,totalFees );

        do{
            System.out.println("-------Student Menu-------");
            System.out.println("1. Display");
            System.out.println("2. Pay fees");
            System.out.println("3. View Pending Fess");
            System.out.println("4. Update course");
            System.out.println("5. Exit");

            input = "";
            System.out.print("Enter your choice : ");

            while(true){
                input = scanner.next();
                scanner.nextLine();
                if(input.length() == 1 && (input.charAt(0) >= '1' && input.charAt(0) <= '7' )){
                    choice = Integer.parseInt(input);
                    break;
                }
                System.out.print("Enter valid choice (between 1 to 5) : ");
            }

            switch (choice){
                case 1:
                    student1.displayAllDetails();
                    break;

                case 2:
                    if(feesPaid >= totalFees){
                        System.out.println("Fees already paid...");
                        break;
                    }
                    System.out.print("Enter amount to pay : ");
                    while (true) {
                        amount = scanner.nextDouble();
                        if (amount > 0 && amount <= totalFees && student1.getPendingFees() > 0) {
                            break;
                        }
                        System.out.print("Enter valid amount : ");
                    }

                    student1.payFees(amount);

                    break;

                case 3:
                    System.out.println("Pending fees : " + student1.getPendingFees());
                    break;

                case 4:
                    while (true) {
                        try {
                            System.out.print("Enter new course : ");
                            newCourse = scanner.nextLine();
                            student1.setCourse(newCourse);
                            break;

                        }  catch (Exception e) {
                            System.out.println("Please enter a valid name.");
                        }
                    }

                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Enter valid choice...");
                     break;
            }

        }while (choice != 5);
    }

    }
