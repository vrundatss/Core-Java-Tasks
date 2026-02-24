package com.tss.OrderStreamAssign;

import com.tss.AccountCollectionAssign.UtilityAccountMethods;

import java.util.*;
import java.util.stream.Collectors;


public class OrderStreamMain {
    static List<Order> orders = Arrays.asList(
            new Order(101 , "Vrunda" , "Electronics"  , 10  , 100.0  , "Pending"),
            new Order(102 , "Jayesh" , "Electronics"  , 20  , 2000.0  , "Delivered"),
            new Order(103 , "Jayesh" , "Food"  , 5  , 200.0  , "Shipped"),
            new Order(104 , "DEF" , "Food"  , 4  , 500.0  , "Delivered"),
            new Order(105 , "Lmn" , "Clothing"  , 8  , 1000.0  , "Shipped"),
            new Order(106 , "Jayesh" , "Clothing"  , 6  , 3000.0  , "Pending"),
            new Order(107 , "Vrunda" , "Electronics"  , 15  , 1000.0  , "Delivered")
    );

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do{
            displayMenu();

            System.out.print("Enter you choice : ");
            choice= UtilityAccountMethods.readPositiveNumber();

            switch (choice){
                case 1 -> showOrderOfCustomer();
                case 2 -> showDeliveredOrders();
                case 3 -> showAllDistinctCategories();
                case 4 -> showTotalRevenueOfShipped();
                case  5 -> avgQuantityOfElectronics();
                case 6 -> highestTotalRevenue();
                case 7 -> ordersWithCount();
                case 8 -> moreThan2PlacedOrders();
                case 9 -> top3TotalRevenue();
                case 10 -> checkForQuantityLessThan10();
                default -> System.out.println();
            }
        }while (choice != 0);

    }

    private static void displayMenu(){
        System.out.println("1. All orders of particular customer ");
        System.out.println("2. All Delivered orders");
        System.out.println("3. All Distinct Categories");
        System.out.println("4. Total Revenue for all shipped orders");
        System.out.println("5. Average quantity of items ordered for Electronics");
        System.out.println("6. Highest Total Revenue");
        System.out.println("7. Group orders by status and count of each");
        System.out.println("8. Customers who have placed more than 2 orders");
        System.out.println("9. Top 3 Sorted orders by Total Revenue in descending order");
        System.out.println("10. Check all orders in Clothing category have quantity < 10 ?");
        System.out.println("0. Exit");
    }

    private static void showOrderOfCustomer() {
        System.out.println();
        System.out.println("------ All Customers ------");

        List<String> customers = orders.stream()
                .map(Order::getCoustomerName)
                .distinct()
                .toList();

        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter customer name or number to view their orders: ");
        String input = scanner.nextLine();

        String selectedCustomer;

        if (input.matches("\\d+")) {
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < customers.size()) {
                selectedCustomer = customers.get(index);
            } else {
                System.out.println("Invalid selection!");
                return;
            }
        } else {
            selectedCustomer = input;
        }

        System.out.println();
        System.out.println("Orders for customer: " + selectedCustomer);

        orders.stream()
                .filter(order -> order.getCoustomerName().equalsIgnoreCase(selectedCustomer))
                .forEach(System.out::println);

        System.out.println("\n----------------------------------------------");
    }


//    private static void showOrderOfCustomer(){
//        System.out.println();
//        System.out.println("1. All orders of Jayesh :");
//        orders.stream()
//                .filter(order -> order.getCoustomerName().equalsIgnoreCase("Jayesh"))
//                .forEach(order -> System.out.println(order));
//
//        System.out.println("\n--------------------------------------------------------------------------------");
//        System.out.println();
//    }

    private static void showDeliveredOrders(){
        System.out.println();

        System.out.println("2. All Delivered orders : ");
        orders .stream()
                .filter(order -> order.getStatus().equalsIgnoreCase("Delivered"))
                .forEach(order -> System.out.println(order.toString()));

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println();
    }

    private static void showAllDistinctCategories(){

        System.out.println();
        System.out.println("3. All Distinct Categories :");

        orders.stream()
                .map(Order::getProductCategory)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println();
    }

    private static void showTotalRevenueOfShipped(){
        System.out.println();
        System.out.println("4. Total Revenue for all shipped orders :");

        double totalRevenue = orders .stream()
                .filter(p -> p.getStatus().equalsIgnoreCase("Shipped"))
                .mapToDouble(p -> p.getQuantity() * p.getPricePerUnit())
                .sum();

        System.out.println(totalRevenue);

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println();
    }

    private static void avgQuantityOfElectronics(){
        System.out.println();
        System.out.println("5. Average quantity of items ordered for Electronics:");
        double avgQuantity = orders.stream()
                .filter(p -> p.getProductCategory().equalsIgnoreCase("Electronics"))
                .mapToInt(Order::getQuantity)
                .average()
                .orElse(0.0);

//        double avgQuantity = orders .stream()
//                .filter(p -> p.getorderCategory().equalsIgnoreCase("Electronics"))
//                .collect(Collectors.averagingInt(order::getQuantity));

        System.out.println(avgQuantity);

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println();
    }

    private static void highestTotalRevenue(){

        System.out.println();
        System.out.println("6. Highest Total Revenue :");
        double maxTotalRevenue = orders .stream()
                .collect(Collectors.groupingBy(
                        Order::getStatus,
                        Collectors.summingDouble(p -> p.getQuantity() * p.getPricePerUnit())
                ))
                .values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElse(0.0);

        System.out.println(maxTotalRevenue);


        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println();
    }

    private static void ordersWithCount(){
        System.out.println();
        System.out.println("7. Group orders by status and count of each :");

//        orders .stream()
//                .map(Order::getStatus)
//                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
//                .forEach((status, count) -> System.out.println(status + " : " + count));

        orders .stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()))
                .forEach((status , count) -> System.out.println(status + " : " + count));


        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println();
    }

    private static void moreThan2PlacedOrders(){
        System.out.println();
        System.out.println("8. Customers who have placed more than 2 orders :");
        orders .stream()
                .collect(Collectors.groupingBy(Order::getCoustomerName, Collectors.counting()))
                .entrySet()
                .stream().filter(entry -> entry.getValue() > 2)
                .forEach(entry -> System.out.println("Customer name => " + entry.getKey() + " , Orders : " + entry.getValue()));

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println();
    }

    private static void top3TotalRevenue(){
        System.out.println();
        System.out.println("9. Top 3 Sorted orders by Total Revenue in descending order :");
        orders .stream()
                .collect(Collectors.groupingBy(
                        Order::getStatus,
                        Collectors.summingDouble(p -> p.getQuantity() * p.getPricePerUnit())
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String , Double>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()) );


        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println();
    }

    private static void checkForQuantityLessThan10(){
        System.out.println();
        System.out.println("10. is all orders in Clothing category have quantity < 10 ?");

        boolean isLessThan10 = orders .stream()
                .filter(order -> order.getProductCategory().equalsIgnoreCase("Clothing"))
                .allMatch(order -> order.getQuantity() < 10);

        System.out.println(isLessThan10);
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println();

    }
}
