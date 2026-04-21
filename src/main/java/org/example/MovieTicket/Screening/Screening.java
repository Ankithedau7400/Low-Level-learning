package org.example.MovieTicket.Screening;

import org.example.MovieTicket.Cinema.Room;

import java.time.Duration;
import java.time.LocalDateTime;

public class Screening {
    private final String id;
    private final Movie movie;
    private final Room room;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public Screening(String id, Movie movie, Room room, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.movie = movie;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }

     public Movie getMovie() {
        return movie;
    }
    public Room getRoom(){
        return room;
    }
    public String getId(){
        return id;
    }
}
