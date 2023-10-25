/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author vudinhthi2304
 */
public class MovieAnalytics {
    public List<Movie> movies;

    public MovieAnalytics() {
        this.movies = new ArrayList<>();
    }
    
    public static Consumer<Movie> showInfo() {
        return movie -> {
            String info = movie.getTitle() + " (By " + movie.getDirector() + ", " + movie.getReleaseYear() + ")";
            System.out.println(info);
        };
    }

    public void populateWithData(String fileName){
        try {
            Stream<String> lines = Files.lines(Paths.get(fileName));
            lines.forEach(line -> {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    String title = parts[0];
                    int releaseYear = Integer.parseInt(parts[1]);
                    int duration = Integer.parseInt(parts[2]);
                    String genre = parts[3];
                    double score = Double.parseDouble(parts[4]);
                    String director = parts[5];
                    Movie movie = new Movie(title, releaseYear, duration, genre, score, director);
                    movies.add(movie);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stream<Movie> moviesAfter(int year){
        return movies.stream().filter(movie -> movie.getReleaseYear() >= year)
        .sorted(Comparator.comparing(Movie::getReleaseYear)).sorted(Comparator.comparing(Movie::getTitle));
    }

    public Stream<Movie> moviesBefore(int year){
        return movies.stream().filter(movie -> movie.getReleaseYear() <= year)
        .sorted(Comparator.comparing(Movie::getReleaseYear)).sorted(Comparator.comparing(Movie::getTitle));
    }

    public Stream<Movie> moviesBetween(int yearA, int yearB){
        return movies.stream().filter(movie -> movie.getReleaseYear() >= yearA && movie.getReleaseYear() <= yearB)
        .sorted(Comparator.comparing(Movie::getReleaseYear)).sorted(Comparator.comparing(Movie::getTitle));
    }

    public Stream<Movie> moviesByDirector(String director){
        return movies.stream().filter(movie -> movie.getDirector().equals(director)).sorted()
        .sorted(Comparator.comparing(Movie::getReleaseYear)).sorted(Comparator.comparing(Movie::getTitle));
    }

}
