package com.tss.model;

import java.util.Scanner;

public class StudentsManagementSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter number of students (max 10): ");
        int n;
        while (true) {
            n = scanner.nextInt();
            if (n > 0 && n <= 10) {
                break;
            }
            System.out.print("Only 1–10 students allowed. \nEnter number of students again: ");
        }

        Student[] students = new Student[n];
        int count = 0;
        int choice;

        do {
            System.out.println("\n====== Student Management Menu ======");
            System.out.println("1. Add new student");
            System.out.println("2. Pay fees");
            System.out.println("3. View pending fees");
            System.out.println("4. Display a student");
            System.out.println("5. Display all students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter a valid number (1–6): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            boolean idAlreadyExists = true;

            switch (choice) {
                case 1:
                    if (count >= n) {
                        System.out.println("Cannot add more students. Limit reached.");
                        break;
                    }

                    int id = 0;
                    System.out.print("Enter ID: ");
                    while (idAlreadyExists) {
                        id = readPositiveId();
                        idAlreadyExists = false;

                        for (int i = 0; i < students.length; i++) {

                            if (students[i] != null && students[i].getId() == id) {
                                idAlreadyExists = true;
                                break;
                            }
                        }

                        if (idAlreadyExists) {
                            System.out.println("Id Already exist... ");
                            System.out.print("Enter another id :");
                        }
                    }

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter Fees Paid: ");
                    double feesPaid = readValidDouble(0, 1000000);

                    System.out.print("Enter Total Fees: ");
                    double totalFees;
                    while (true) {
                        totalFees = readValidDouble(0, 1000000);
                        if (totalFees >= feesPaid)
                            break;
                        System.out.print("Total fees must be >= fees paid. \nEnter total fees again: ");
                    }

                    students[count] = new Student(id, name, course, feesPaid, totalFees);
                    System.out.println("Student added successfully!");
                    count++;
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No students added yet!");
                        break;
                    }
                    Student s1 = findStudentById(students, count);
                    if (s1 != null) {
                        if (s1.getPendingFees() == 0) {
                            System.out.println("All fees already paid for this student.");
                            break;
                        }
                        System.out.println("Pending fees: Rs. " + s1.getPendingFees());
                        System.out.print("Enter amount to pay: ");
                        double amount = readValidDouble(0, s1.getPendingFees());
                        s1.payFees(amount);
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No students added yet!");
                        break;
                    }
                    Student s2 = findStudentById(students, count);
                    if (s2 != null) {
                        System.out.println("Pending fees for Id " + s2.getId() + " : " + s2.getPendingFees() );
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No students to display.");
                        break;
                    }
                    Student s3 = findStudentById(students, count);
                    if (s3 != null) s3.displayAllDetails();
                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("------ All Students ------");
                        System.out.printf("%-5s %-20s %-20s %-10s %-10s" , "ID" , "Name" , "Course" , "Fees Paid" , "Total Fees" );
                        System.out.println();
                        for (int i = 0; i < count; i++) {
                            students[i].displayAllDetails();
//                            System.out.println("--------------------------");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Enter valid choice (1–6).");
            }

        } while (choice != 6);
    }

    private static int readPositiveId() {
        while (true) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                scanner.nextLine();
                if (num > 0) return num;
            } else {
                scanner.next();
            }
            System.out.print("Enter valid positive integer: ");
        }
    }

    private static double readValidDouble(double min, double max) {
        while (true) {
            if (scanner.hasNextDouble()) {
                double val = scanner.nextDouble();
                scanner.nextLine();
                if (val >= min && val <= max) return val;
            } else {
                scanner.next();
            }
            System.out.print("Enter valid amount (" + min + " - " + max + "): ");
        }
    }

    private static Student findStudentById(Student[] students, int count) {
        System.out.print("Enter Student ID: ");
        int id = readPositiveId();
        for (int i = 0; i < count; i++) {
            if (students[i] != null && students[i].getId() == id) {
                return students[i];
            }
        }
        System.out.println("No student found with ID " + id);
        return null;
    }
}

