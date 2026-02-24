package com.tss;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceAssign {
    public static void main(String[] args) {
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        BiFunction<Integer , Integer, Integer> addition = (a, b) -> (a + b);

        Consumer<Integer> square = (n) -> System.out.println( n * n );

        Supplier<LocalDate> todayDate = () -> LocalDate.now();

        checkOdd(isOdd);

        addTwoValues(addition);

        squareOfNumber(square);

        printTodaysDate(todayDate);

    }
    public static void checkOdd(Predicate isOdd){
        System.out.println(isOdd.test(10));
    }

    public static void addTwoValues(BiFunction addition){
        System.out.println(addition.apply(10 , 20));
    }

    public static void squareOfNumber(Consumer square){
        System.out.println();
    }

    public static void printTodaysDate(Supplier todayDate){
        System.out.println(todayDate.get());
    }
}
