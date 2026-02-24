package com.tss.AccountStreamAssign;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        List<Account> accounts = List.of(
          new Account(101 , "Vrunda" , 10000.0),
          new Account(102 , "ABCDEC" , 20000.0),
          new Account(103 , "XYZPWCD" , 250000.0),
            new Account(104 , "DEXYZPWCD" , 25000.0)

        );

        System.out.println("Account of Minimum balance : ");

        Optional<Account> minAccount = accounts.stream()
                .sorted(Comparator.comparing(Account :: getBalance))
                .findFirst();

        System.out.println(minAccount.toString());

        System.out.println();

        System.out.println("Account of Maximum balance : ");

        Optional<Account> maxAccount = accounts.stream()
                .sorted(Comparator.comparing(Account :: getBalance).reversed())
                .findFirst();

        System.out.println(maxAccount.toString());


        System.out.println();
        System.out.println("Account of holder name greater than 6 characters : ");

        accounts.stream()
                .filter(a -> a.getHolderName().length() > 6)
                .forEach(System.out::println);


//        System.out.println(acc.toString());

        System.out.println();
        System.out.println("Total balance of all Accounts : ");

        Optional<Double> totalBalance = accounts.stream()
                .map(Account::getBalance)
                .reduce(Double :: sum);

        System.out.println(totalBalance);

    }
}
