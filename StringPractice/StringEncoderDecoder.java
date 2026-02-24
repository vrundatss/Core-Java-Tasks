package com.tss.StringPractice;

import java.util.Scanner;

public class StringEncoderDecoder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter a String to Encode : ");
        String input = scanner.nextLine().toLowerCase();

        StringBuilder sbEncode = new StringBuilder(encode(input)).reverse();
        String encoded = sbEncode.toString();
        System.out.println("\nEncoded String : " + encoded);

        StringBuilder sbDecode = new StringBuilder(encoded).reverse();
        String decoded = decode(sbDecode.toString());
        System.out.println("\nDecoded String : " + decoded);
    }

    private static String encode(String input) {
        StringBuilder sb = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                switch (ch) {
                    case 'a':
                        sb.append('@');
                        break;
                    case 'e':
                        sb.append('#');
                        break;
                    case 'i':
                        sb.append('!');
                        break;
                    case 'o':
                        sb.append('*');
                        break;
                    case 'u':
                        sb.append('$');
                        break;
                }
            } else if (Character.isLetter(ch)) {
                if(ch == 'z'){
                    ch = 'a';
                    sb.append(ch);

                }else {
                    ch = (char) (ch + 1);
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    private static String decode(String input) {
        StringBuilder sb = new StringBuilder();

        for (char ch : input.toCharArray()) {
            switch (ch) {
                case '@':
                    sb.append('a');
                    break;
                case '#':
                    sb.append('e');
                    break;
                case '!':
                    sb.append('i');
                    break;
                case '*':
                    sb.append('o');
                    break;
                case '$':
                    sb.append('u');
                    break;
                default:
                    if (Character.isLetter(ch)) {

                        if(ch == 'a'){
                            ch = 'z';
                            sb.append(ch);

                        }else {
                            ch = (char) (ch -1);
                            sb.append(ch);
                        }
                    } else {
                        sb.append(ch);
                    }
                    break;
            }
        }

        return sb.toString();
    }
}
