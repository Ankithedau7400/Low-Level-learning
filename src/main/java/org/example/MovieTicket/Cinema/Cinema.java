package org.example.MovieTicket.Cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final String name;
    private final String location;
    private List<Room> rooms;

    public Cinema(String name, String location) {
        this.name = name;
        this.location = location;
        this.rooms = new ArrayList<>();
    }
    public void addRooms(Room room){
        rooms.add(room);

    }
}
