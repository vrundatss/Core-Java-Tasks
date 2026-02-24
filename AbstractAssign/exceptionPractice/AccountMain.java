package com.tss.AbstractAssign.exceptionPractice;

import com.tss.AccountCollectionAssign.Transaction;
import com.tss.ExceptionAssign.UtilityAccountMethods;
import com.tss.ExceptionAssign.exceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.tss.AccountCollectionAssign.AccountMain.transaction;


public class AccountMain {
    public static Scanner scanner = new Scanner(System.in);
    public static final int MAX_ACCOUNTS = 100;

    public static List<Account> accounts = new ArrayList<>(MAX_ACCOUNTS);
    public static int accountCount = accounts.size();

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();

            choice = getChoice();

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
                    deleteAnAccount();
                    break;

                case 7:
                    displayAccountDetails();
                    break;

                case 8:
                    displayAllAccountDetails();
                    break;

                case 9:
                    showTransactionsOfAccount();
                    break;

                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter valid choice (1 to 7)!");
                    break;
            }

        } while (choice != 10);
    }

    private static void displayMenu(){
        System.out.println("\n============ BANK MANAGEMENT SYSTEM ============");
        System.out.println("1. Create an Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Show Balance");
        System.out.println("5. Transfer money to another Account");
        System.out.println("6. Delete an Account");
        System.out.println("7. Display an Account Details");
        System.out.println("8. Display All Account Details");
        System.out.println("9. Show Transaction of Account");
        System.out.println("10. Exit");
    }

    private static int getChoice(){
        System.out.print("Enter your choice : ");
        String input;
        int choice;
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
        return choice;
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

        accounts.add(newAccount);
        accountCount++;

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
        Account account = findAccountListByAccountNumber();
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
    }

    private static void withdrawAmount() {
        Account account = findAccountListByAccountNumber();
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

    }

    private static void showBalance() {
        Account account = findAccountListByAccountNumber();
        if (account == null) return;

        System.out.println("Current Balance: Rs. " + account.getBalance());
    }

    private static void transferMoney() {
        if (accountCount == 1) {
            System.out.println("Only One Account is present and self transfer is not allowed...");
            return;
        }

        System.out.println("From Account (Sender) ==>");
        Account senderAccount = findAccountListByAccountNumber();
        if (senderAccount == null) return;

        System.out.println("To Account (Receiver) ==>");
        Account receiverAccount = findAccountListByAccountNumber();

        if (receiverAccount == null) return;

        if(senderAccount == receiverAccount){
            System.out.println("Self Transfer is not allowed...");
        }

        double amount = UtilityAccountMethods.getValidAmount("Enter amount to transfer : ");

        if(senderAccount.getBalance() < amount){
            System.out.println("Insufficient balance for transfer...");
            return;
        }

        senderAccount.withdraw(amount);

        receiverAccount.deposit(amount);

        System.out.println( amount +  " rs. Transferred Successfully!!!...  ");
    }

    private static void deleteAnAccount(){
        Account account = findAccountListByAccountNumber();
        if(account != null){
            accounts.remove(account);
            accountCount--;
            System.out.println();
        }

    }

    private static void displayAccountDetails() {
        Account account = findAccountListByAccountNumber();

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
            Account account = accounts.get(i);
            account.displayAccountDetails(account);

            System.out.println("-------------------------------------------------------------------");
        }
    }


    public static Account findAccountListByAccountNumber() {
        System.out.print("Enter Account Number : ");
        int number = UtilityAccountMethods.readPositiveNumber();
        for (int i = 0; i < accountCount; i++) {
            if (accounts.get(i) != null && accounts.get(i).getAccountNumber() == number) {
                return accounts.get(i);
            }
        }
        System.out.println("No account found with this Account number " + number);
        return null;
    }
    private static void showTransactionsOfAccount() {
    Account account = findAccountListByAccountNumber();

        if (account != null)
        {
            System.out.printf("| %-15s | %-15s | %-15s | %-13s | %-10s | %-15s |\n",
                    "Transaction ID",  "From Account No" , "To Account No", "Type" , "Amount", "Current Balance");
            System.out.println("-------------------------------------------------------------------------------------------------");

            List<com.tss.AccountCollectionAssign.Transaction> transactions =  account.getTrasactions();
            for (int i = 0; i < transactions.size(); i++)
            {
                transaction = transactions.get(i);
                transaction.displayTransactionDetails(transaction);
            }
        }
    }

    private static void displayAllTransactions() {
        if (accounts == null || accounts.isEmpty()) {
            System.out.println("No accounts found in the system.");
            return;
        }

        System.out.printf("| %-15s | %-15s | %-15s | %-13s | %-10s | %-15s |\n",
                "Transaction ID", "From Account No", "To Account No", "Type", "Amount", "Current Balance");
        System.out.println("-------------------------------------------------------------------------------------------------");

        boolean hasTransactions = false;

        for (Account account : accounts) {
            if (account == null) continue;

            List<com.tss.AccountCollectionAssign.Transaction> transactions = account.getTrasactions();

            if (transactions == null || transactions.isEmpty()) {
                continue;
            }
            hasTransactions = true;
            for (Transaction transaction : transactions) {
                transaction.displayTransactionDetails(transaction);
            }
        }
        if (!hasTransactions) {
            System.out.println("No transactions available in the system.");
            return;
        }
    }


}


