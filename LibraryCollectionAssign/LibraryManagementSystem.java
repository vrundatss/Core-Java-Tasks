package com.tss.LibraryCollectionAssign;

import com.tss.LibraryCollectionAssign.UtilityMethods.Utils;
import com.tss.LibraryCollectionAssign.exception.BookAlreadyBorrowedException;
import com.tss.LibraryCollectionAssign.exception.DuplicateEmailException;
import com.tss.LibraryCollectionAssign.exception.InvalidBookException;
import com.tss.LibraryCollectionAssign.exception.InvalidMemberException;
import com.tss.LibraryCollectionAssign.model.Book;
import com.tss.LibraryCollectionAssign.service.Library;
import com.tss.LibraryCollectionAssign.model.Member;

import java.util.List;
import java.util.Scanner;

import static com.tss.LibraryCollectionAssign.UtilityMethods.Utils.*;

public class LibraryManagementSystem {
    private static List<Member> members;
    Book book;
    Member member;
    public static Library library = new Library();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InvalidMemberException, InvalidBookException, BookAlreadyBorrowedException {

        int choice;

        do {
            displayMenu();

            choice = getChoice();

            switch (choice) {
                case 1:
                    addABook();
                    break;

                case 2:
                    addAMember();
                    break;

                case 3:
                    borrowABook();
                    break;

                case 4:
                    System.out.print("Enter Member ID : ");
                    Integer memberId = Utils.readPositiveNumber();
                    library.showAMember(memberId);
                    break;

                case 5:
                    library.viewAvailableBooks();
                    break;

                case 6:
                    library.viewAllBooks();
                    break;

                case 7:
                    library.viewAllMembers();
                    break;

                case 8:
                    System.out.print("Enter Member ID : ");
                    Integer borrowedMemberId = Utils.readPositiveNumber();
                    try {
                        library.booksBorrowedByMember(borrowedMemberId);
                    } catch (InvalidMemberException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 9:
                    System.out.print("Enter Book ID : ");
                    Integer bookId = Utils.readPositiveNumber();
                    try {
                        library.findBorrowerOfBook(bookId);
                    }catch (Exception e){
                        System.out.println("Book is not borrowed...Borrow it first...");
                    }
                    break;

                case 10:
                    library.showAllBorrowedBooks();
                    break;

                case 11:
                    returnABook();
                    break;

                case 12:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter valid choice (1 to 11)!");
                    break;
            }

        } while (choice != 12);

    }

    public static void displayMenu(){
        System.out.println("\n============ Library MANAGEMENT SYSTEM ============");
        System.out.println("1.  Add a Book");
        System.out.println("2.  Add a Member");
        System.out.println("3.  Borrow a Book");
        System.out.println("4.  Show a Member");
        System.out.println("5.  View Available Books");
        System.out.println("6.  View All Books");
        System.out.println("7.  View All Members");
        System.out.println("8.  View Books borrowed by a member");
        System.out.println("9.  Find Borrower of a Book");
        System.out.println("10. Show All Borrowed Books");
        System.out.println("11. Return a Book");
        System.out.println("12. Exit");
    }

    public static void addABook(){
        System.out.print("Enter Book Title : ");
        String title = getValidString();
        System.out.print("Enter Author Name : ");
        String author = getValidString();

        System.out.println("Select Category : ");
        BookCategory[] categories = BookCategory.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }

        int choice;
        BookCategory category = null;
        while (true) {
            System.out.print("Enter your choice (1-" + categories.length + ") : ");
            String input = scanner.nextLine().trim();

            if (input.matches("\\d+")) {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= categories.length) {
                    category = categories[choice - 1];
                    break;
                }
            }
            System.out.println("Invalid choice. Please try again.");
        }

        try {
            Book book = new Book(title, author, category);
//            library.add(book);
            library.addBook(book);
            System.out.println("Book added successfully with category: " + category);
        } catch (InvalidBookException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkDuplicateEmail(String email, List<Member> members) throws DuplicateEmailException {
        for (Member member : members) {
            if (member.getEmail().equalsIgnoreCase(email)) {
                throw new DuplicateEmailException("Email '" + email + "' is already registered!");
            }
        }
    }

    public static void addAMember() {
        System.out.print("Enter Member Name : ");
        String name = getValidString();

        while (true){
            String email = Utils.getValidEmail();

            try {
                checkDuplicateEmail(email, library.getMembers());
                Member member1 = new Member(name , email);
                library.addMember(member1);

                System.out.println("Member added successfully!");
                break;

            } catch (InvalidMemberException e) {
                System.out.println(e.getMessage());
            } catch (DuplicateEmailException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public static void borrowABook()  {
        System.out.print("Enter Member ID : ");
        Integer memberId = Utils.readPositiveNumber();

        boolean hasAvailable = library.viewAvailableBooks();
        if (!hasAvailable) {
            System.out.println("No books available to borrow right now.");
            return;
        }
        System.out.print("Enter Book ID to borrow : ");
        Integer bookId = Utils.readPositiveNumber();

        try {
            library.borrowBook(bookId, memberId);
        } catch (InvalidBookException | InvalidMemberException | BookAlreadyBorrowedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void returnABook() {
        System.out.print("Enter Book ID to return: ");
        int bookId = Utils.readPositiveNumber();

        System.out.print("Enter Member ID returning the book: ");
        int memberId = Utils.readPositiveNumber();

        try {
            library.returnBook(bookId, memberId);
        } catch (InvalidBookException | InvalidMemberException e) {
            System.out.println(e.getMessage());
        }
    }

}
