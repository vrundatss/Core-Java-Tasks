package com.tss.StreamsPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {

//        List<Integer> numbers = List.of(1 ,2, 3 ,4, 5);
        List<Integer> numbers = Arrays.asList(10, 2, 8, 4, 6);
//        Stream<Integer> numberStream = numbers.stream();

//        numbers.stream()
//                .peek( number -> System.out.println(number))
//                .forEach(number -> System.out.print());


//        numbers.add(20);
//            numbers.remove(2);
//        numbers.set(0 , 20);

//        numbers.forEach((number) -> System.out.println(number));
//        numbers.stream()
//                .forEach((number) -> System.out.println(number) );

        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);



//        List<Integer> squares = numbers.stream()
//                .filter((number) -> number % 2 == 1)
//                .map((number) -> number * number)
//                .collect(Collectors.toList());
//
//        squares.stream()
//                .forEach(System.out :: println);


//        Stream s = numberStream.filter(number -> number % 2 == 0);
//
//        System.out.println(s);
//        List<Integer> nums = List.of(1, 2, 3, 4, 5);

//        int sum = nums.stream()
//                .filter(n -> n % 2 == 1)
//                .reduce(0, Integer::sum);
//        System.out.println(sum);

//
//        Set<Integer> unique = nums.stream()
//                .collect(Collectors.toSet());
//
//        System.out.println(unique);
    }
}
