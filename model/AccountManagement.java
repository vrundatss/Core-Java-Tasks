package com.tss.model;

import java.util.Scanner;

public class AccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Number : ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter Account Holder Name : ");
        String name = scanner.nextLine();
        scanner.nextLine();

        System.out.print("Enter Balance : ");
        double  balance = scanner.nextDouble();

        System.out.print("1. Savings  2. Current  3. Salary \nEnter Account type : ");
        int type = scanner.nextInt();

        AccountType[] types = AccountType.values();
        AccountType accountType = null;
        if (type >= 1 && type <= types.length) {
            accountType = types[type - 1];
        } else {
            System.out.println("Invalid choice!");
        }

        Account account = new Account(accountNumber , name , balance ,accountType);

        System.out.println("\nAccount Details ==> ");
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Account Holder Name : " + account.getName());
        System.out.println("Account Balance : " + account.getBalance());
        System.out.println("Account Type : " + accountType);


//        System.out.println("Number of Accounts : " + Account.counter);
    }
}
