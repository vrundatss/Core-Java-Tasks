package com.tss.practice;

import java.util.Random;

public class CurrentAccount extends BankAccount{

    private double overdraftLimit= 5000;
    private static final Random random = new Random();

    public CurrentAccount(String holderName, double balance) {
        super("CUR" + (100000 + random.nextInt(900000)), holderName, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount < 0){
            System.out.println("Withdrawal amount must be positive...");
            return;
        }
        if(amount > balance + overdraftLimit){
            System.out.println("Withdrawal limit exceeds the overdraft limit of rs. " + overdraftLimit);
            return;
        }

            balance -= amount;
            System.out.println("Withdrawn rs. " + amount + " from Current Account (Overdraft allowed).");

    }
}
