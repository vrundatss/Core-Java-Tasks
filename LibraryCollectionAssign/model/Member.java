package com.tss.LibraryCollectionAssign.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private Integer memberId;
    private String memberName;
    private String email;
    private  static int nextId = 0;

    public List<Book> borrowedBooks = new ArrayList<>();

    public Member( String memberName, String email) {
        this.memberId = ++nextId;
        this.memberName = memberName;
        this.email = email;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        int borrowedCount = borrowedBooks == null ? 0 : borrowedBooks.size();

        return String.format(
                "| %-10d | %-15s | %-20s | %-15d |",
                memberId,
                memberName,
                email,
                borrowedCount
        );
    }
}
