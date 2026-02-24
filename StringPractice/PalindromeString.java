package com.tss.StringPractice;

import java.util.Scanner;

public class PalindromeString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a String : ");
        String input = scanner.next();
        StringBuilder sb = new StringBuilder(input);

        sb.reverse();
        String reversedString = reverseString(input);
        System.out.println();
        if(input.equals(reversedString)){
            System.out.println(input + " is a Palindrome string.");
        }
        else {
            System.out.println(input + " is not a Palindrome string.");
        }
    }

    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

}
