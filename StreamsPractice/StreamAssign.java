package com.tss.StreamsPractice;

import java.util.Comparator;
import java.util.List;

public class StreamAssign {
    public static void main(String[] args) {
        List<String> names = List.of("Jayesh" , "Nimesh" , "Mark" , "Mahesh" , "Ramesh" , "abc");

        System.out.println("First 3 Students in ascending order :");
        names.stream()
                .sorted()
                .limit(3)
                .forEach((name) -> System.out.println(name));

        System.out.println();

        System.out.println("All first 3 names contains 'a': ");

        names.stream()
                .sorted()
                .filter(n -> n.contains("a"))
                .limit(3)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("First 3 Students in descending order :");
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach((name) -> System.out.println(name));


        System.out.println();

        System.out.println("First 3 Character of all names :");
        names.stream()
                .map((name) -> name.substring(0 , 3))
                .forEach((name) -> System.out.println(name));



        System.out.println();

        System.out.println("Names that contains less than or equal to 4 characters  :");
        names.stream()
                .filter(name -> name.length() <= 4)
                .forEach(System.out::println);

    }
}
