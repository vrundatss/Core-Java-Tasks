package com.tss.ExceptionAssign.exceptions;

public class MinimumBalanceException extends RuntimeException{
    public  static final double MIN_BALANCE = 500;
    private double balance;
    public MinimumBalanceException(double balance) {

        this.balance = balance;
    }

    @Override
    public String getMessage() {
        return "Can't withdraw...\nMinimum balance of rs. " +  MIN_BALANCE + " must be maintained.";


    }
}
