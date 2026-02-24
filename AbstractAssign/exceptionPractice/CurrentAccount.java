package com.tss.AbstractAssign.exceptionPractice;

import com.tss.ExceptionAssign.exceptions.MinimumBalanceException;
import com.tss.ExceptionAssign.exceptions.NegativeAmountException;


public class CurrentAccount extends Account {
    private static final double MIN_BALANCE = 500;

    public CurrentAccount(String holderName  , double balance) {
        super( holderName , balance);
    }

    @Override
    public void withdraw(double amount) throws NegativeAmountException {

        try {
            if (balance - amount < MIN_BALANCE) {
                throw new MinimumBalanceException(amount);
            }
                balance -= amount;
                System.out.println("Withdrawn rs. " + amount + " from Current account.");

        }catch (MinimumBalanceException e){
            System.out.println(e.getMessage());
        }

    }
}
