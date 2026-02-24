package com.tss.model;

public class Account {
    private int id =0 ;
    private int AccountNumber;
    private String name;
    private double balance;
    private AccountType type;

    static int counter;

    public Account() {
        this.id = 0;
        AccountNumber = 0;
        this.name = "Unknown";
        this.balance = 0;
        counter++;
    }

    public Account( int accountNumber, String name, double balance, AccountType type) {
        this.id = ++id;
        AccountNumber = accountNumber;
        this.name = name;
        this.balance = balance;

        counter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

//    public String getAccountType() {
//        return AccountType;
//    }
//
//    public void setAccountType(String accountType) {
//        AccountType = accountType;
//    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
