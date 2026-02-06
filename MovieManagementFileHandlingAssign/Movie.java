package com.tss.MovieManagementFileHandlingAssign;

import java.io.Serializable;

public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private static int counter = 0;

    private String name;
    private int year;
    private String genre;

    public Movie(String name, int year, String genre) {
        this.id = ++counter;
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static void setIdCounter(int value) {
        counter = value;
    }

    public static int getIdCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
