package com.tss.practice;

import java.util.Scanner;

public class BankAccountMain {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        String input = " ";
        int choice;
        do{
            System.out.println("\n============ BANK MANAGEMENT SYSTEM ============");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");

            System.out.print("Enter your choice : ");

            while(true){
                input = scanner.next();
                scanner.nextLine();
                if(input.length() == 1 && (input.charAt(0) >= '1' && input.charAt(0) <= '7' )){
                    choice = Integer.parseInt(input);
                    break;
                }
                System.out.print("Enter valid choice (between 1 to 6) : ");
            }

            switch (choice){
                case 1:
                    account = createSavingsAccount();
                    break;

                case 2:
                    account = createCurrentAccount();
                    break;

                case 3:
                    depositAmount(account);
                    break;

                case 4:
                    withdrawAmount(account);
                    break;

                case 5:
                    account.displayAccountDetails();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Enter valid choice...");
                    break;
            }

        }while (choice != 6);
    }

    private static BankAccount createSavingsAccount(){
        System.out.print("Enter Account Holder Name: ");
        String holderName = scanner.nextLine();

        double balance = getValidAmount("Enter Initial Balance: ");

        System.out.println("Current Account Created Successfully!");


        return new SavingsAccount(holderName , balance);
    }

    private static BankAccount createCurrentAccount(){
        System.out.print("Enter Account Holder Name : ");
        String holderName = scanner.nextLine();
        double balance= 0;
        while (true){
            balance= getValidAmount("Enter initial balance : ");

            if(balance >= 500){
                System.out.println("Savings Account Created Successfully!");
                break;
            }else {
                System.out.println("Minimum balance for Current Account is rs. 500");
            }
        }

        return new CurrentAccount(holderName, balance);
    }

    private static void depositAmount(BankAccount account){
        double amount = getValidAmount("Enter amount to deposit : ");
        account.deposit(amount);
    }

    private static void withdrawAmount(BankAccount account){
        double amount = getValidAmount("Enter amount to withdraw : ");
        account.withdraw(amount);
    }

    private static double getValidAmount(String msg){
        double amount;
        while (true){
            System.out.print(msg);

            if(scanner.hasNextDouble()){
                amount = scanner.nextDouble();
                scanner.nextLine();
                if(amount > 0){
                    return amount;
                }
                else {
                    System.out.println("Enter positive amount...");
                }
            }
            else {
                System.out.println("Enter a valid input...");
            }
        }
    }
}
