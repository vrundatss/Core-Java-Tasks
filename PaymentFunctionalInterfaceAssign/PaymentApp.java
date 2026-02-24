package com.tss.PaymentFunctionalInterfaceAssign;

import java.util.Scanner;

public class PaymentApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        boolean success = false;

        do {
            System.out.print("Enter amount to pay: ");
            double amount = scanner.nextDouble();

            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            Payment payment = null;

            switch (choice) {
                case 1 -> payment = (amountToPay) -> amountToPay <= 100000;
                case 2 -> payment = (amountToPay) -> amountToPay <= 50000;
                case 3 -> payment = (amountToPay) -> true;
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice, Enter valid choice...");
            }

            if (payment != null) {
                success = processPayment(payment, amount);
                System.out.println(success ? "Payment Successful!" : "Payment Failed!");
            }

        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("\n---- Payment Options ----");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Net Banking");
        System.out.println("0. Exit");
    }

    private static Boolean processPayment(Payment payment, Double amount) {
        return payment.pay(amount);
    }
}
