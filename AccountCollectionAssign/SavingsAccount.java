package com.tss.AccountCollectionAssign;

import com.tss.ExceptionHandlingAssign.exceptions.NegativeAmountException;

public class SavingsAccount extends Account {
    private double OFFER_RATE = 3;

    public SavingsAccount(String holderName ,  double balance) {
        super( holderName , balance);
    }

    @Override
    public void withdraw(Double amount) throws NegativeAmountException {
        if (amount <= 0) {
            throw new NegativeAmountException(amount);
        }
            balance -= amount;
            System.out.println("Withdrawn Rs. " + amount + " from Current Account.");
            System.out.println("Updated Balance: Rs. " + balance);
    }

    @Override
    public void deposit(Double amount) throws NegativeAmountException {
        double extra = 0;

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
