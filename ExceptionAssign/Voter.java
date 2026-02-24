package com.tss.ExceptionAssign;

import com.tss.ExceptionAssign.exceptions.AgeNotValidException;

public class Voter {
    int id;
    String name;
    int age;

    public Voter(int id, String name, int age) {
        this.id = id;
        this.name = name;

        if(age < 18){
            throw new AgeNotValidException(age);
        }
        this.age = age;
    }
}
