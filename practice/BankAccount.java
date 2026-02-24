package com.tss.practice;

import java.util.Random;

public class BankAccount {
    protected String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount() {
        this.accountNumber = "0000";
        this.holderName = "Unknown";
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String holderName, double balance) {
        Random random = new Random();
        this.accountNumber = "ACC" + (100000 + random.nextInt(900000)); 
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Deposit amount must be positive...");
            return;
        }
        balance += amount;
        System.out.println("Deposited : rs. " + amount);
    }

    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Withdrawal amount must be positive...");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance...");
        } else {
            balance -= amount;
            System.out.println("Withdrawn : rs. " + amount);
        }
    }

    public void displayAccountDetails(){
        System.out.println("-------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder Name : "+ holderName);
        System.out.println("Available Balance : "+ balance );
        System.out.println("-------------------------------");

    }
}
