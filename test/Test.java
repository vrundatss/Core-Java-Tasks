package com.tss.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int sum = 0;
        double sumDouble = 0.0;

        String array[] = {"10", "20", "15.25","x", "30.5"};

        for (String s : array){
            if(isDigit(s)){
                sum +=  Integer.parseInt(s);
            } else if (isChar(s)) {
                continue;
            }
            else {
                sumDouble += Double.parseDouble(s);
            }

        }

        System.out.println("Sum of Integers : " + sum);

        System.out.println("Sum of Doubles : " + sumDouble);

    }
    private static boolean isDigit(String input){
        if(input.matches("[0-9]+")){
            return true;
        }
        else {
            return  false;
        }
    }

    private static boolean isChar(String input){
        if(input.matches("[A-Za-z]+")){
            return true;
        }
        else {
            return  false;
        }
    }
}
