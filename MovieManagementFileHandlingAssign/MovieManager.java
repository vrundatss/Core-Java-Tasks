package com.tss.MovieManagementFileHandlingAssign;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager{

    private static final int MAX_MOVIES = 5;
    private static final String SERIAL_FILE = "movie.ser";
    private static final String TEXT_FILE = "C:\\Users\\vrunda.chavada\\Training Projects\\Java projects\\OOP-App-TSS\\src\\com\\tss\\fileHandlingAssign\\MovieData\\data.txt";

    private static ArrayList<Movie> movies;
    private final Scanner scanner = new Scanner(System.in);

    public MovieManager() {
        this.movies = new ArrayList<>();
        loadMovie();
    }

    public void addMovie(Movie movie) throws CapacityFullException {
        if (movies.size() < MAX_MOVIES) {
            movies.add(movie);
//            saveMovie();
            System.out.println("Movie added successfully with Movie ID: " + movie.getId());
        } else {
            throw new CapacityFullException("Limit Reached! Only " + MAX_MOVIES + " movies allowed.");
        }
    }


    public void clearMovies() {
        movies.clear();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public Movie getMovieById(int id) throws NoSuchMovieFoundException {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        throw new NoSuchMovieFoundException("Movie with ID " + id + " not found!");
    }


    public void loadMovie() {
        movies.clear();
        File file = new File(SERIAL_FILE);

        if (!file.exists()) {
            System.out.println("No existing movie file found.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIAL_FILE))) {
            while (true) {
                try {
                    Movie movie = (Movie) ois.readObject();
                    movies.add(movie);
                } catch (Exception e) {
                    break;
                }
            }
            System.out.println("Movies loaded successfully! (" + movies.size() + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!movies.isEmpty()) {
            int maxId = 0;
            for (Movie m : movies) {
                if (m.getId() > maxId) {
                    maxId = m.getId();
                }
            }
            Movie.setIdCounter(maxId);
        }
        displayMovies();
    }

    public void saveMovie() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE))) {
            for (Movie movie : movies) {
                oos.writeObject(movie);
            }
            System.out.println("Movies serialized to movie.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEXT_FILE))) {
            for (Movie movie : movies) {
                bw.write(movie.getId() + "," + movie.getName() + "," + movie.getYear() + "," + movie.getGenre());
                bw.newLine();
            }
            System.out.println("Movie details saved in data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAMovie(int id) {
        boolean removed = false;

        for (Movie m : new ArrayList<>(movies)) {
            if (m.getId() == id) {
                movies.remove(m);
                removed = true;
                break;
            }
        }
        if (!removed) {
            try {
                throw new NoSuchMovieFoundException("Movie with ID " + id + " not found!");
            } catch (NoSuchMovieFoundException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        saveMovie();

        System.out.println("Movie with ID " + id + " deleted successfully!");
    }


    public void deleteAllMovies() {
        clearMovies();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEXT_FILE))) {
            bw.write(" ");
            System.out.println("All movies deleted successfully.");
        } catch (IOException e) {
            System.out.println("Error while deleting file: " + e.getMessage());
        }

        File f = new File(SERIAL_FILE);
        if (f.exists()) f.delete();
    }

    public void displayMovies() {
        if (movies != null && !movies.isEmpty()) {
            System.out.println("Loaded Movies:");
            System.out.println("--------------------------------");
            for (Movie m : movies) {
                System.out.println(m);
            }
            System.out.println("--------------------------------");
        } else {
            System.out.println("No movies to display!");
        }
    }
}



//package com.tss.fileHandlingAssign;
//import com.tss.InheritancePractice.UtilityAccountMethods;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//public class MovieManager implements Serializable {
//
//    private static final int MAX_MOVIES = 5;
//    Scanner scanner = new Scanner(System.in);
//
//    private static ArrayList<Movie> movies;
//
//    static final String fileName = "C:\\Users\\vrunda.chavada\\Training Projects\\Java projects\\OOP-App-TSS\\src\\com\\tss\\fileHandlingAssign\\MovieData\\data.txt";
//
//    public MovieManager(ArrayList<Movie> movies) {
//        this.movies = new ArrayList<>();
//    }
//
//    public void addMovie(Movie movie){
//        if(movies.size() < MAX_MOVIES) {
//            movies.add(movie);
//            saveMovie();
//            System.out.println("Movie added successfully with Movie ID : "  +movie.getId() );
//        }else {
//            System.out.println("Limit Reached...Only "+ MAX_MOVIES +" moives can be added...");
//        }
//    }
//
//    public void clearMovies(){
//        movies.clear();
//    }
//
//    public ArrayList<Movie> getMovies() {
//        return movies;
//    }
//
//    public static Movie getMovieId(){
//        System.out.print("Enter Moive ID :");
//        int id = UtilityAccountMethods.readPositiveNumber();
//        Movie movie = movies.get(id);
//
//        return movie;
//    }
//
//    public void loadMovie(){
//        if(movies.size() <= MAX_MOVIES) {
//            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("movie.ser"))) {
//                for (int i = 0; i < movies.size(); i++) {
//                    Movie movie = (Movie) ois.readObject();
////                System.out.println(movie);
//                }
//                System.out.println("Object De-serialized successfully!");
//
//                if (movies != null && !movies.isEmpty()) {
//                    System.out.println("Loaded Movies:");
//                    for (Movie m : movies) {
//                        System.out.println(m);
//                    }
//                } else {
//                    System.out.println("No Movies Found!!!...Add movie first...");
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//    }
//
//    public void saveMovie(){
//
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movie.ser"))) {
//
//            for (int i = 0; i < movies.size(); i++){
//                oos.writeObject(movies.get(i));
//            }
//
//            System.out.println("Object serialized successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
//            for (Movie movie : movies) {
//                bw.write(movie.getId() + "," + movie.getName() + "," + movie.getYear() + "," + movie.getGenre());
//                bw.newLine();
//            }
//            System.out.println("Movie details saved in data.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteAllMovies(){
//        clearMovies();
//
//        try (FileWriter fw = new FileWriter(fileName)) {
//
//                String line = " ";
//
//                fw.write(line);
//
//            System.out.println("All movies deleted successfully.");
//        } catch (IOException e) {
//            System.out.println("Error while deleting file: " + e.getMessage());
//        }
//    }
//
//}
