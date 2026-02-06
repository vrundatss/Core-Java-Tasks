package com.tss.AccountCollectionAssign;

import com.tss.ExceptionHandlingAssign.exceptions.NegativeAmountException;

import java.util.*;

public abstract class Account {
    private static Integer nextId = 0;

    protected Integer id;
    private static Set<Integer> accountSet = new HashSet<>();
    private Integer accountNumber;
    private String holderName;
    protected Double balance;
    private AccountType accountType;
    private TrasactionType trasactionType;
    public List<Transaction> trasactions = new ArrayList<>();

    public Account() {
        this.holderName = "Unknown";
        this.balance = 0.0;
    }

    public Account(String holderName , Double balance) {
        this.id = ++nextId;
        Random random = new Random();

        Integer number = 100 + random.nextInt(900);
        while (accountSet.contains(number)){
            number = 100 + random.nextInt(900);
        }
        accountNumber = number;
        accountSet.add(number);

        this.holderName = holderName;
        this.balance = balance;
    }

    public Account(Integer id, Integer accountNumber, String holderName, Double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;

        accountSet.add(accountNumber);
        if (id > nextId) {
            nextId = id;
        }
    }

    public static void setNextId(int maxId) {
        nextId  = maxId;
    }

    public Integer getId() {
        return id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public Double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public TrasactionType getTrasactionType() {
        return trasactionType;
    }

    public void setTrasactionType(TrasactionType trasactionType) {
        this.trasactionType = trasactionType;
    }

    public List<Transaction> getTrasactions() {
        return trasactions;
    }

    public void setTrasactions(List<Transaction> trasactions) {
        this.trasactions = trasactions;
    }

    public abstract void deposit(Double amount) throws NegativeAmountException;

    public abstract void withdraw(Double amount) throws NegativeAmountException;

//    public void deposit(Double amount){
////        if(amount <= 0){
////            System.out.prIntegerln("Deposit amount must be positive...");
////            return;
////        }
//        balance += amount;
//        System.out.println("Deposited : rs. " + amount);
//    }
//
//    public void withdraw(Double amount){
//        if (amount > balance) {
//            System.out.println("Insufficient balance...");
//        } else {
//            balance -= amount;
//            System.out.println("Withdrawn : rs. " + amount);
//        }

//        throw new NegativeAmountException(amount);

//    }

    public void addTransaction(Transaction transaction){
        trasactions.add(transaction);
    }

    public void displayAccountDetails(Account account) {
        System.out.printf("| %-5d | %-10d | %-15s | %-10s | %-12.2f |\n",
                account.getId(),
                account.getAccountNumber(),
                account.getHolderName(),
                account.getAccountType(),
                account.getBalance());
    }

}


