package com.tss.LibraryCollectionAssign.exception;

public class BookAlreadyBorrowedException extends Exception{
    public BookAlreadyBorrowedException(String message){
        super(message);
    }
}
