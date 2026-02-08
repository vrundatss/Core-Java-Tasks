package com.tss.ExceptionHandlingAssign;

import java.util.Random;

public class Account {
    private static int nextId = 0;

    protected int id;
    protected long accountNumber;
    private String holderName;
    protected double balance;
    protected String accountType;

    public Account() {
        this.accountNumber = 000;
        this.holderName = "Unknown";
        this.balance = 0.0;
    }

    public Account(long accountNumber , String holderName , double balance) {
        this.id = ++nextId;
        Random random = new Random();
        this.accountNumber = 100 + random.nextInt(900);
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

//    public abstract void deposit(double amount);
//
//    public abstract void withdraw(double amount);

    public void deposit(double amount){
//        if(amount <= 0){
//            System.out.println("Deposit amount must be positive...");
//            return;
//        }
        balance += amount;
        System.out.println("Deposited : rs. " + amount);
    }

    public void withdraw(double amount){
        if (amount > balance) {
            System.out.println("Insufficient balance...");
        } else {
            balance -= amount;
            System.out.println("Withdrawn : rs. " + amount);
        }

//        throw new NegativeAmountException(amount);

    }

    public void displayAccountDetails(Account acc) {
        System.out.printf("| %-5d | %-10d | %-15s | %-10s | %-12.2f |\n",
                acc.getId(),
                acc.getAccountNumber(),
                acc.getHolderName(),
                acc.getAccountType(),
                acc.getBalance());
    }

}


