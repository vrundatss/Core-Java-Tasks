package com.tss.StringPractice;

import java.util.Scanner;

public class ReverseWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a Sentence : ");

        String input = scanner.nextLine();

        String[] splited = input.split(" ");

        String result = "";

        for (String word : splited){
            String reversed = " ";

            for(int i = word.length() - 1; i >= 0 ; i--){
                reversed += word.substring( i , i + 1);
            }
            result += reversed + " ";
        }
        System.out.println("\nResult of reversed words : " + result.trim());
    }

}
