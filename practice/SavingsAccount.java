package com.tss.practice;

import java.util.Random;

public class SavingsAccount extends BankAccount {
    private double minBalance = 1000;
    private static final Random random = new Random();

    public SavingsAccount(String holderName, double balance) {
        super("SAV" + (100000 + random.nextInt(900000)), holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive...");
            return;
        }

        if (balance - amount < minBalance) {
            System.out.println("Cannot withdraw rs. " + amount + ". Minimum balance of rs. " + minBalance + " must be maintained.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn rs. " + amount + " from Savings account.");
        }
    }
}
