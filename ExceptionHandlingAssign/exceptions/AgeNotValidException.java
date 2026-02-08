package com.tss.ExceptionHandlingAssign.exceptions;

public class AgeNotValidException extends RuntimeException{
    private int age;

    public AgeNotValidException(int age) {
        this.age = age;
    }

    @Override
    public String getMessage() {
        return "Age not Valid. Must be greater than 18. You entered : " + age;
    }
}
