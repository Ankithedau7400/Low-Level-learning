package org.example.RestaurantManager;

import java.time.LocalDateTime;

// Represents a reservation made at the restaurant for a specific party, time and table
public class Reservation {
    private final String partyName;
    private final int partySize;
    private final LocalDateTime time;
    private final Table assignedTable;

    public Reservation(
            String partyName, int partySize, LocalDateTime time, Table assignedTable) {
        this.partyName = partyName;
        this.partySize = partySize;
        this.time = time;
        this.assignedTable = assignedTable;
    }

    public int getPartySize() {
        return partySize;
    }

    public String getPartyName() {
        return partyName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Table getAssignedTable() {
        return assignedTable;
    }
    // getter methods are omitted for brevity
}

