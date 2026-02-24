package com.tss.ExceptionAssign;

import java.time.Year;

import static com.tss.AbstractAssign.exceptionPractice.AccountMain.scanner;
import static com.tss.ExceptionAssign.AccountMain.accountCount;
import static com.tss.ExceptionAssign.AccountMain.accounts;


public class UtilityAccountMethods {

    public static int readValidYear() {
        int year;
        int currentYear = Year.now().getValue();

        while (true) {
            System.out.print("Enter Start year (between 1960 and " + currentYear + "): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid numeric year.");
                scanner.next();
                continue;
            }

            scanner.nextLine();
            year = scanner.nextInt();
            if (year >= 1960 && year <= currentYear) {
                return year;
            } else {
                System.out.println("Invalid year. Please enter a year between 1960 and " + currentYear + ".");
            }
        }
    }

    public static double getValidAmount(String msg) {
        double amount;
        while (true) {
            System.out.print(msg);
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                scanner.nextLine();
                if (amount > 0) {
                    return amount;
                } else {
                    System.out.println("Enter positive amount...");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }
    }

    public static String getValidString(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();

            if (!input.isEmpty() && input.matches("[A-Za-z ]+")) {
                return input;
            }

            System.out.println("Enter a valid name (letters only, no numbers or special characters).");
        }
    }


    public static int readPositiveNumber() {
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

    public static Account findAccountByAccountNumber() {
        System.out.print("Enter Account Number : ");
        int number = readPositiveNumber();
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == number) {
                return accounts[i];
            }
        }
        System.out.println("No account found with this Account number " + number);
        return null;
    }

}

