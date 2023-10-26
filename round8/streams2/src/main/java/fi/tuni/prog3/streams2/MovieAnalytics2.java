/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.streams2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author vudinhthi2304
 */

public class MovieAnalytics2 {
    public List<Movie> movies;

    public MovieAnalytics2() {
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

    public void printCountByDirector(int n){
        Map<String, Long> directorMovieCount = movies.stream()
        .collect(Collectors.groupingBy(Movie::getDirector, Collectors.counting()));

        directorMovieCount.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
        .thenComparing(Map.Entry.<String, Long>comparingByKey()))
        .limit(n)
        .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " movies"));
    }

    public void printAverageDurationByGenre(){
        Map<String, Double> AverageDurationByGenre = movies.stream()
        .collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingInt(Movie::getDuration)));

        AverageDurationByGenre.entrySet().stream()
        .sorted(Map.Entry.<String, Double>comparingByValue()
        .thenComparing(Map.Entry.<String, Double>comparingByKey()))
        .forEach(entry -> System.out.format("%s: %.2f%n", entry.getKey(), entry.getValue()));
    }

    public void printAverageScoreByGenre(){
        Map<String, Double> AverageScoreByGenre = movies.stream()
        .collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingDouble(Movie::getScore)));

        AverageScoreByGenre.entrySet().stream()
        .sorted(Map.Entry.<String, Double>comparingByValue().reversed()
        .thenComparing(Map.Entry.<String, Double>comparingByKey()))
        .forEach(entry -> System.out.format("%s: %.2f%n", entry.getKey(), entry.getValue()));

    }
}
