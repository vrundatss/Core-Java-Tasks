package com.tss.MovieManagementFileHandlingAssign;

import com.tss.AccountCollectionAssign.UtilityAccountMethods;


public class MovieController {
    MovieManager movieManager;

    public MovieController(MovieManager movieManager) {
        this.movieManager = movieManager;
    }

    public void start(){
        displayMenu();
    }

    public void displayMenu(){
        System.out.println("==========Movie Menu==========");
        System.out.println("1. Add Movie");
        System.out.println("2. Update Movie");
        System.out.println("3. Display Movie by ID");
        System.out.println("4. Display All Movies");
        System.out.println("5. Delete Movie by ID");
        System.out.println("6. Clear All Movies");
        System.out.println("7. Exit");

    }

    public Movie setMovieDetails() throws NoSuchMovieFoundException {
        System.out.print("Enter Movie ID to edit details: ");
        int id = UtilityAccountMethods.readPositiveNumber();

        Movie movieToEdit = null;

        for (Movie m : movieManager.getMovies()) {
            if (m.getId() == id) {
                movieToEdit = m;
                break;
            }
        }

        if (movieToEdit == null) {
            throw new NoSuchMovieFoundException("Movie with ID " + id + " not found!");
        }

        String name = UtilityAccountMethods.getValidString("Edit Movie Name: ");
        System.out.print("Edit year: ");
        int year = MovieApp.readValidYear();
        String genre = UtilityAccountMethods.getValidString("Edit Movie Genre: ");

        movieToEdit.setName(name);
        movieToEdit.setYear(year);
        movieToEdit.setGenre(genre);

        System.out.println("Movie details updated successfully!");

        movieManager.saveMovie();
        System.out.println("Changes saved to file!");

        return movieToEdit;
    }

}
