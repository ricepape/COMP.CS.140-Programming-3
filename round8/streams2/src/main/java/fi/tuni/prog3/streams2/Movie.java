/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.streams2;

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
    
        @Override
        public int compareTo(Movie other) {
        if (this.releaseYear < other.releaseYear) {
            return -1; // Return a negative number to indicate "this" is less than "other"
        } else if (this.releaseYear > other.releaseYear) {
            return 1; // Return a positive number to indicate "this" is greater than "other"
        } else {
            // If release years are the same, compare by title
            return this.title.compareTo(other.title);
        }
    }
}
