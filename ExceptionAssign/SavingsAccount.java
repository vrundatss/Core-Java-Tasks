package com.tss.ExceptionAssign;

import java.util.Random;

public class SavingsAccount extends Account {
    private double OFFER_RATE = 3;
    private static final Random random = new Random();

    public SavingsAccount(String holderName ,  double balance) {
        super((100 + random.nextInt(900)), holderName , balance);
    }

    @Override
    public void deposit(double amount){
        double extra = 0;
//        if(amount <= 0){
//            System.out.println("Deposit amount must be positive...");
//            return;
//        }

        if(amount > 50000){
            extra = (amount * OFFER_RATE / 100);
            balance += amount + extra;

            System.out.println("Deposited : rs. " + amount);
            System.out.println("Extra amount added : rs. " + extra);
        }else {
            balance += amount;
            System.out.println("Deposited : rs. " + amount);
        }
    }
}
