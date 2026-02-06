package com.tss.AccountCollectionAssign;

import com.tss.ExceptionHandlingAssign.exceptions.MinimumBalanceException;
import com.tss.ExceptionHandlingAssign.exceptions.NegativeAmountException;


public class CurrentAccount extends Account {
    private static final Double MIN_BALANCE = 500.0;

    public CurrentAccount(String holderName  , Double balance) {
        super( holderName , balance);
    }

    @Override
    public void deposit(Double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }

        balance += amount;
        System.out.println("Deposited Rs. " + amount + " to Current Account.");
        System.out.println("Updated Balance: Rs. " + balance);
    }

    @Override
    public void withdraw(Double amount) throws NegativeAmountException {
        if (amount <= 0) {
            throw new NegativeAmountException(amount);
        }

        try {
            if (balance - amount < MIN_BALANCE) {
                throw new MinimumBalanceException(amount);
            }
            balance -= amount;
            System.out.println("Withdrawn Rs. " + amount + " from Current Account.");
            System.out.println("Updated Balance: Rs. " + balance);

        } catch (MinimumBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
