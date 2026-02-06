package com.tss.LibraryCollectionAssign.model;

import com.tss.LibraryCollectionAssign.BookCategory;

import java.util.*;

public class Book {
    private Integer bookId;
    private Integer bookNumber;
    private Set<Integer> bookNumbers = new HashSet<>();
    private String title;
    private String author;
    private BookCategory category;
    public Boolean isBorrowed;
    private static Integer nextId = 0;

//    LinkedHashSet<Book> books = new LinkedHashSet<>();

    public Book(String title, String author, BookCategory category) {
        this.bookId = ++nextId;

        Random random = new Random();
        int number = 100000000 + random.nextInt(900000000);
        while (bookNumbers.contains(number)) {
            number = 100000000 + random.nextInt(900000000);
        }
        this.bookNumber = number;
        bookNumbers.add(number);

        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = false;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-7d | %-8d | %-15s | %-15s | %-12s | %-15s |",
                bookId,
                bookNumber,
                title,
                author,
                category,
                isBorrowed ? "Yes" : "No"
        );
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookNumber() {
        return bookNumber;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookCategory getCategory() {
        return category;
    }

}
