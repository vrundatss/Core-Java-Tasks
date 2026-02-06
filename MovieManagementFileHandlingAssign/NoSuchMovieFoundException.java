package com.tss.MovieManagementFileHandlingAssign;

public class NoSuchMovieFoundException extends Exception {
    public NoSuchMovieFoundException(String message) {
        super(message);
    }
}