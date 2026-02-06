package com.tss.LibraryCollectionAssign.UtilityMethods;

import com.tss.LibraryCollectionAssign.exception.InvalidEmailException;
import com.tss.LibraryCollectionAssign.model.Book;

import java.util.Scanner;

import static com.tss.LibraryCollectionAssign.LibraryManagementSystem.library;

public class Utils {
    static Scanner scanner = new Scanner(System.in);

    static Book book;

    public static void printBookHeader() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("| %-7s | %-8s | %-15s | %-15s | %-12s | %-15s |\n",
                "Book ID", "ISBN No", "Title", "Author", "Category", "Is Borrowed");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public static void printMemberHeader() {
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-15s | %-20s | %-15s |\n",
                "Member ID", "Name", "Email" , "Borrowed books");
        System.out.println("----------------------------------------------------------------------------------------------");
    }

    public static int getChoice() {
        System.out.print("Enter your choice: ");
        int choice;

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.matches("\\d+")) {
                choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= 12) {

                    if ((choice == 3 || choice == 5 || choice == 6 || choice == 8 || choice == 9 || choice == 10 || choice == 11)
                            && library.getBooks().isEmpty()) {
                        System.out.print("No books found! Please add a book first (choose option 1).\nEnter choice again: ");
                        continue;
                    }

                    if ((choice == 3 || choice == 4 || choice == 8 || choice == 9 || choice == 11)
                            && library.getMembers().isEmpty()) {
                        System.out.print("No members found! Please add a member first (choose option 2).\nEnter choice again: ");
                        continue;
                    }
                    break;
                }
            }
            System.out.print("Enter valid choice (between 1 to 12): ");
        }
        return choice;
    }

    public static String getValidString() {
        String input;
        while (true) {
            input = scanner.nextLine().trim();

            if (!input.isEmpty() && input.matches("[A-Za-z ]+")) {
                return input;
            }

            System.out.println("Enter a valid name (letters only, no numbers or special characters).");
        }
    }


    public static int readPositiveNumber() {
        while (true) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                scanner.nextLine();
                if (num > 0) return num;
            } else {
                scanner.next();
            }
            System.out.print("Enter valid positive integer: ");
        }
    }

    public static String getValidEmail() {
        while (true) {
            System.out.print("Enter Email: ");
            String email = scanner.nextLine().trim();

            try {
                validateEmail(email);
                return email;
            } catch (InvalidEmailException e) {
                System.out.println( e.getMessage());
            }
        }
    }

    public static void validateEmail(String email) throws InvalidEmailException{

        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

        if (email == null || email.isEmpty()) {
            throw new InvalidEmailException("Email cannot be empty.");
        }

        if (!email.matches(regex)) {
            throw new InvalidEmailException("Invalid email format. Example: user@example.com");
        }
    }



}
