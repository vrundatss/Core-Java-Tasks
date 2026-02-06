package com.tss.ExceptionAssign;

import com.tss.ExceptionAssign.exceptions.MinimumBalanceException;

import java.util.Random;

public class CurrentAccount extends Account {
    private static final double MIN_BALANCE = 500;
    private static final Random random = new Random();

    public CurrentAccount(String holderName  , double balance) {
        super((100 + random.nextInt(900)) , holderName , balance);
    }

    @Override
    public void withdraw(double amount) {
//        if (amount <= 0) {
//            System.out.println("Withdrawal amount must be positive...");
//            return;
//        }

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
