package com.tss.LibraryCollectionAssign.service;

import com.tss.LibraryCollectionAssign.exception.BookAlreadyBorrowedException;
import com.tss.LibraryCollectionAssign.exception.DuplicateEmailException;
import com.tss.LibraryCollectionAssign.exception.InvalidBookException;
import com.tss.LibraryCollectionAssign.exception.InvalidMemberException;
import com.tss.LibraryCollectionAssign.model.Book;
import com.tss.LibraryCollectionAssign.model.Member;

import java.util.*;

import static com.tss.LibraryCollectionAssign.UtilityMethods.Utils.printBookHeader;
import static com.tss.LibraryCollectionAssign.UtilityMethods.Utils.printMemberHeader;

public class Library {
    Set<String> emailSet = new HashSet<>();
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();

//    Map<Integer , LinkedHashSet<Book>> totalBooks = new HashMap<>();

    Map<Integer , Book> bookIdMap = new HashMap<>();
    Map<Integer , Member> memberIdMap = new HashMap<>();

    Map<Integer , Integer> borrowedBooks = new HashMap<>();
    Map<Integer , Set<Integer>> memberBorrowMap = new HashMap<>();

    Map<Book , Member> borrowedBooksObjectMap = new HashMap<>();

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    private boolean isDuplicateBook(Book newBook) throws InvalidBookException {
        for (Book existingBook : books) {

            if (existingBook.getTitle().equalsIgnoreCase(newBook.getTitle())
                    && existingBook.getAuthor().equalsIgnoreCase(newBook.getAuthor())
                    && existingBook.getCategory() != newBook.getCategory()) {
                throw new InvalidBookException("Each book can belong to only one unique category.");
            }

            if (existingBook.getTitle().equalsIgnoreCase(newBook.getTitle())
                    && existingBook.getAuthor().equalsIgnoreCase(newBook.getAuthor())
                    && existingBook.getCategory() == newBook.getCategory()) {
                return true;
            }
        }
        return false;
    }

    public void addBook(Book book) throws InvalidBookException {

        if (isDuplicateBook(book)) {
            throw new InvalidBookException(
                    "Duplicate book not allowed...\nBook with the same title, author, and category already exists."
            );
        }

        books.add(book);
        bookIdMap.put(book.getBookId(),  book);

        System.out.println("Book added successfully with Book Number : " + book.getBookNumber());
    }

    public void addMember(Member member) throws InvalidMemberException , DuplicateEmailException {

        members.add(member);
        memberIdMap.put(member.getMemberId() , member);
        emailSet.add(member.getEmail());

        System.out.println("Member added successfully with Member ID : " + member.getMemberId());
    }


    public void borrowBook(Integer bookId , Integer memberId) throws InvalidBookException , InvalidMemberException , BookAlreadyBorrowedException {

        Member member;
        Book book = bookIdMap.get(bookId);
        if(book.isBorrowed){
            throw  new BookAlreadyBorrowedException("Book is already borrowed...");
        }

        memberBorrowMap.put(memberId , new HashSet<>());

        book.isBorrowed = true;

        member = getMemberById(memberId);
        member.borrowedBooks.add(book);

        borrowedBooks.put(bookId  ,memberId);

        memberBorrowMap.get(memberId).add(bookId);

        borrowedBooksObjectMap.put(book, member);

        System.out.println("Book borrowed successfully...");
    }

    public boolean viewAvailableBooks() {
        System.out.println("--------------------------------------------- Available Books ---------------------------------------------");
        printBookHeader();

        boolean found = false;

        for (Book book : books) {
            if (!book.isBorrowed) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books found!");

        }
        return found;
    }


    public void showAMember(Integer memberId) throws InvalidMemberException{
        printMemberHeader();
        for (Member member : members){
            if(member.getMemberId().equals(memberId)){
                System.out.println(member);
            }
        }
    }

    public void viewAllBooks(){
        System.out.println("--------------------------------------------- All Books ---------------------------------------------");
        printBookHeader();

        for (Book book : books){
            System.out.println(book);
        }
    }

    public void viewAllMembers(){
        System.out.println("--------------------------------------------- All Members ---------------------------------------------");
        printMemberHeader();
        for (Member member : members){
            System.out.println(member);
        }
    }

    public void booksBorrowedByMember(Integer memberId) throws InvalidMemberException {
        Member member = getMemberById(memberId);
        if (member == null) {
            throw new InvalidMemberException("No member found with ID: " + memberId);
        }

        if (member.getBorrowedBooks() == null || member.getBorrowedBooks().isEmpty()) {
            System.out.println("Member " + member.getMemberName() + " has not borrowed any books.");
            return;
        }

        System.out.println("\n-------------------- Books Borrowed by " + member.getMemberName() + " --------------------");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("| %-7s | %-8s | %-20s | %-15s | %-12s | %-9s |\n",
                "Book ID", "ISBN No", "Title", "Author", "Category", "Borrowed");
        System.out.println("----------------------------------------------------------------------------------------------");

        for (Book book : member.getBorrowedBooks()) {
            System.out.println(book);
        }

        System.out.println("----------------------------------------------------------------------------------------------");
    }


    public void findBorrowerOfBook(Integer bookId) throws InvalidBookException{
        if(!borrowedBooks.containsKey(bookId)){
            System.out.println("Book is not borrowed yet...");
        }
        int memberId = borrowedBooks.get(bookId);
//        int id = memberIdMap.get(memberId);
        System.out.println("Book is borrowed by Member : \n");
        printMemberHeader();
        System.out.println(memberIdMap.get(memberId));
    }

    public void showAllBorrowedBooks() {
        System.out.println("--------------------------------------------- Borrowed Books ---------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-7s | %-8s | %-20s | %-15s | %-12s | %-10s | %-20s |\n",
                "Book ID", "ISBN No", "Title", "Author", "Category", "Member ID", "Borrowed By");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        if (borrowedBooksObjectMap.isEmpty()) {
            System.out.println("No books are currently borrowed.");
            return;
        }

        for (Map.Entry<Book, Member> entry : borrowedBooksObjectMap.entrySet()) {
            Book book = entry.getKey();
            Member member = entry.getValue();

            System.out.printf("| %-7d | %-8d | %-20s | %-15s | %-12s | %-10d | %-20s |\n",
                    book.getBookId(),
                    book.getBookNumber(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getCategory(),
                    member.getMemberId(),
                    member.getMemberName());
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }


    public Member getMemberById(Integer memberId) throws InvalidMemberException{
        for (Member member : members){
            if(member.getMemberId().equals(memberId)){
                return member;
            }
        }
        return null;
    }

    public void returnBook(Integer bookId, Integer memberId)
            throws InvalidBookException, InvalidMemberException {

        Member member = getMemberById(memberId);
        if (member == null) throw new InvalidMemberException("Invalid member ID: " + memberId);

        Book book = bookIdMap.get(bookId);
        if (book == null) throw new InvalidBookException("Invalid book ID: " + bookId);

        if (!book.isBorrowed) {
            System.out.println("Book is not borrowed currently.");
            return;
        }

        if (!borrowedBooks.containsKey(bookId) || borrowedBooks.get(bookId) != memberId) {
            System.out.println("This book was not borrowed by this member.");
            return;
        }

        book.isBorrowed = false;

        member.getBorrowedBooks().remove(book);

        borrowedBooks.remove(bookId);

        memberBorrowMap.get(memberId).remove(bookId);

        borrowedBooksObjectMap.remove(book);

        System.out.println("Book returned successfully!");
    }


}
