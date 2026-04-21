package org.example.MovieTicket.Screening;

import java.time.Duration;

public class Movie {
    private final String title;
    private final String genre;
    private final int durationInMinutes;

    public Movie(String title, String genre, int durationInMinutes) {
        this.title = title;
        this.genre = genre;
        this.durationInMinutes = durationInMinutes;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }


    // Getter for genre
    public String getGenre() {
        return genre;
    }

    // Getter for durationInMinutes
    public int getDurationInMinutes() {
        return durationInMinutes;
    }


    public Duration getDuration() {
        return Duration.ofMinutes(durationInMinutes);
    }
}
