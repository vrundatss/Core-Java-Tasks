package com.tss.ExceptionHandlingAssign;

import com.tss.AccountCollectionAssign.UtilityAccountMethods;
import com.tss.ExceptionHandlingAssign.exceptions.*;

import java.util.Scanner;


public class AccountMain {
    public static Scanner scanner = new Scanner(System.in);
    public static final int MAX_ACCOUNTS = 100;

    public static int accountCount = 0;
    public static Account[] accounts = new Account[MAX_ACCOUNTS];

    public static void main(String[] args) {
        String input;
        int choice;

        do {
            System.out.println("\n============ BANK MANAGEMENT SYSTEM ============");
            System.out.println("1. Create an Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Show Balance");
            System.out.println("5. Transfer money to another Account");
            System.out.println("6. Display an Account Details");
            System.out.println("7. Display All Account Details");
            System.out.println("8. Exit");

            System.out.print("Enter your choice : ");

            while(true){
                input = scanner.next();
                scanner.nextLine();
                if(input.length() == 1 && (input.charAt(0) >= '1' && input.charAt(0) <= '8' )){
                        choice = Integer.parseInt(input);

                        if (choice != 1 && accountCount == 0) {
                            System.out.print("No account exists! Please create an account first (choose option 1).\nEnter Choice Again : ");
                        } else {
                            break;
                        }
                }else {
                    System.out.print("Enter valid choice (between 1 to 8) : ");
                }
            }


            switch (choice) {
                case 1:
                    accountCreation();
                    break;

                case 2:
                    depositAmount();
                    break;

                case 3:
                    withdrawAmount();
                    break;

                case 4:
                    showBalance();
                    break;

                case 5:
                    transferMoney();
                    break;

                case 6:
                    displayAccountDetails();
                    break;

                case 7:
                    displayAllAccountDetails();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter valid choice (1 to 7)!");
                    break;
            }

        } while (choice != 8);
    }


    private static void accountCreation() {
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Account limit reached. Cannot create more accounts.");
            return;
        }

        System.out.println("\nChoose Account Type:");
        System.out.println("a. Savings Account");
        System.out.println("b. Current Account");
        System.out.print("Enter your choice (a/b): ");

        String type = scanner.next().toLowerCase();
        scanner.nextLine();

        Account newAccount = null;
        switch (type) {
            case "a":
                newAccount = createSavingsAccount();
                newAccount.setAccountType("Savings");

                break;

            case "b":
                newAccount = createCurrentAccount();
                newAccount.setAccountType("Current");
                break;

            default:
                System.out.println("Invalid account type. Returning to main menu...");
                return;
        }

        accounts[accountCount++] = newAccount;
        System.out.println("Account created successfully with Account Number: " + newAccount.getAccountNumber());
    }

    private static Account createSavingsAccount(){
        String holderName = UtilityAccountMethods.getValidString("Enter Account Holder Name: ");

        double balance = UtilityAccountMethods.getValidAmount("Enter Initial Balance: ");

        System.out.println("Savings Account Created Successfully!");


        return new SavingsAccount(holderName , balance);

    }

    private static Account createCurrentAccount(){
        String holderName = UtilityAccountMethods.getValidString("Enter Account Holder Name: ");

        double balance= 0;
        while (true){
            balance= UtilityAccountMethods.getValidAmount("Enter initial balance : ");

            if(balance >= 500){
                System.out.println("Current Account Created Successfully!");
                break;
            }else {
                System.out.println("Minimum balance for Current Account is rs. 500");
            }
        }

        return new CurrentAccount(holderName, balance);
    }

    private static void depositAmount() {
        Account account = findAccountByAccountNumber();
        if (account == null) return;
        double amount = 0;
        try{
            System.out.print("Enter amount to deposit: ");
            amount = scanner.nextDouble();
            if(amount < 0){
                throw new NegativeAmountException(amount);
            }
            account.deposit(amount);

        }catch (NegativeAmountException e){
            System.out.println(e.getMessage());
        }
//        double amount = UtilityAccountMethods.getValidAmount("Enter amount to deposit: ");
    }

    private static void withdrawAmount() {
        Account account = findAccountByAccountNumber();
        if (account == null) return;

        double amount = 0;
        try{
            System.out.print("Enter amount to withdraw: ");
            amount = scanner.nextDouble();
            if(amount < 0){
                throw new NegativeAmountException(amount);
            }
            account.withdraw(amount);
        }catch (NegativeAmountException e){
            System.out.println(e.getMessage());
        }
//        double amount = UtilityAccountMethods.getValidAmount("Enter amount to withdraw: ");

    }

    private static void showBalance() {
        Account account = findAccountByAccountNumber();
        if (account == null) return;

        System.out.println("Current Balance: Rs. " + account.getBalance());
    }

    private static void transferMoney() {
        System.out.println("From Account (Sender) ==>");
        Account senderAccount = findAccountByAccountNumber();
        if (senderAccount == null) return;

        System.out.println("To Account (Receiver) ==>");
        Account receiverAccount = findAccountByAccountNumber();
        if (receiverAccount == null) return;

        double amount = UtilityAccountMethods.getValidAmount("Enter amount to transfer : ");

        if(senderAccount.getBalance() < amount){
            System.out.println("Insufficient balance for transfer...");
            return;
        }

        senderAccount.withdraw(amount);

        receiverAccount.deposit(amount);

        System.out.println( amount +  " rs. Transferred Successfully!!!...  ");
    }

    private static void displayAccountDetails() {
        Account account = findAccountByAccountNumber();
        if (account != null)
        {
            System.out.printf("| %-5s | %-10s | %-15s | %-10s | %-12s |\n",
                    "ID", "Account No", "Holder Name", "Type", "Balance");
            System.out.println("-------------------------------------------------------------------");

            account.displayAccountDetails(account);

        }
    }

    private static void displayAllAccountDetails() {
        if (accountCount == 0) {
            System.out.println("No accounts available!");
            return;
        }

        System.out.println("\n------------------------ All Accounts -------------------------");
        System.out.printf("| %-5s | %-10s | %-15s | %-10s | %-12s |\n",
                "ID", "Account No", "Holder Name", "Type", "Balance");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccountDetails(accounts[i]);
            System.out.println("-------------------------------------------------------------------");
        }
    }


    public static Account findAccountByAccountNumber() {
        System.out.print("Enter Account Number : ");
        int accountNumber = UtilityAccountMethods.readPositiveNumber();
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getId() == accountNumber) {
                return accounts[i];
            }
        }

        System.out.println("Account with number " + accountNumber + " not found!");
        return null;
    }
}


