package com.tss.ExceptionAssign.exceptions;

public class NegativeAmountException extends RuntimeException{
    private double amount;

    public NegativeAmountException(double amount) {
        this.amount = amount;
    }

    @Override
    public String getMessage() {
        return "Please enter valid positive amount.";
    }
}
