package com.tss.StringPractice;

import java.util.Scanner;

public class StringMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a String : ");
        String input = scanner.nextLine();

//        System.out.println("String in Reverse order : "+ reverseOrder(input));
//
//        firstNonRepeated(input);

//        removeDuplicates(input);

        freqOfChar(input);
    }

    private static void freqOfChar(String input){
        int freq[] = new int[256];

        for (int i = 0; i < input.length(); i++){
            freq[input.charAt(i)]++;
        }

        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(freq[ch] != 0){
                System.out.println("Freq of " + ch + " is : " + freq[ch]);
                freq[ch] =0 ;
            }
        }
    }

    private static void removeDuplicates(String input){

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(sb.indexOf(String.valueOf(ch)) < 0){
                sb.append(ch);
            }
        }
        System.out.println("String after removing duplicates : " + sb.toString());
    }

    private static void firstNonRepeated(String input){
        boolean found = false;
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(input.indexOf(ch) == input.lastIndexOf(ch)){
                System.out.println("First non repeated character : " + ch);
                found = true;
                break;
            }
        }
        if(!found){
                System.out.println("NO any non repeated characters found... ");
        }
    }

    private static String reverseOrder(String input){

        String words[] = input.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i= words.length -1; i >= 0 ; i-- ){
            sb.append(words[i]).append(" ");
        }
        return sb.toString();
    }

}
