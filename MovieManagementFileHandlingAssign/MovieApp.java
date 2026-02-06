package com.tss.MovieManagementFileHandlingAssign;

import com.tss.InheritancePractice.UtilityAccountMethods;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieApp {
    static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Movie> movies;
    static MovieManager movieManager = new MovieManager();
    static MovieController movieController = new MovieController(movieManager);
    public static void main(String[] args) throws NoSuchMovieFoundException {
        int choice;
        do{
            movieController.start();

            System.out.print("Enter your choice : ");

            choice = UtilityAccountMethods.readPositiveNumber();

            switch (choice){
                case 1:
                    addMovie();
                    break;

                case 2:
                    movieController.setMovieDetails();
                    break;

                case 3:
                    System.out.print("Enter Movie ID to Display : ");
                    int id = UtilityAccountMethods.readPositiveNumber();

                    try {
                        Movie found = movieManager.getMovieById(id);
                        System.out.println("Found: " + found);
                    } catch (NoSuchMovieFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    movieManager.loadMovie();
                    break;

                case 5:
                    System.out.print("Enter Movie ID to Delete : ");
                    int idToDelete = UtilityAccountMethods.readPositiveNumber();
                    movieManager.deleteAMovie(idToDelete);
                    break;

                case 6:
                    movieManager.deleteAllMovies();
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Enter Valid Choice...");
            }

        }while (choice != 7);

    }

    public static void addMovie(){
        String name = UtilityAccountMethods.getValidString("Enter Movie Name : ");

        System.out.print("Enter year : ");
        int year = readValidYear();

        String genre = UtilityAccountMethods.getValidString("Enter Genre : ");

        Movie movie = new Movie(name , year , genre);
        try {
            movieManager.addMovie(movie);
        } catch (CapacityFullException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int readValidYear() {
        int year;
        int currentYear = Year.now().getValue();

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid numeric year.");
                scanner.next();
                continue;
            }

            year = scanner.nextInt();
            if (year >= 1960 && year <= currentYear) {
                return year;
            } else {
                System.out.println("Invalid year. Please enter a year between 1960 and " + currentYear + ".");
            }
        }
    }

    }


