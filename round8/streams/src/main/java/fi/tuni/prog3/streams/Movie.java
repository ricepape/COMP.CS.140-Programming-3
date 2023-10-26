/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.streams;

import java.util.Comparator;

/**
 *
 * @author vudinhthi2304
 */
public class Movie implements Comparable<Movie> {
    private String title;
    private int releaseYear;
    private int duration;
    private String genre;
    private double score;
    private String director;

        public Movie(String title, int releaseYear, int duration, String genre, double score, String director) {
            this.title = title;
            this.releaseYear = releaseYear;
            this.duration = duration;
            this.genre = genre;
            this.score = score;
            this.director = director;
        }

        public String getTitle() {
            return title;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public int getDuration() {
            return duration;
        }

        public String getGenre() {
            return genre;
        }

        public double getScore() {
            return score;
        }

        public String getDirector() {
            return director;
        }
    
        public int compareTo(Movie other) {
            if (this.releaseYear < other.releaseYear) {
                return this.releaseYear;
            } else if (this.releaseYear > other.releaseYear) {
                return other.releaseYear;
            } else {
                // If release years are the same, compare by title
                return this.title.compareTo(other.title);
            }
        }

        public static final Comparator<Movie> TITLE_CMP = new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2) {
                int titleComparison = movie1.title.compareTo(movie2.title);
                if (titleComparison != 0) {
                    return titleComparison;
                }
                return Integer.compare(movie1.releaseYear, movie2.releaseYear);
            }
        };

        
    
}
