package org.example.MovieTicket.Cinema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Layout {
    private final int rows;
    private final int columns;

    // Maps seat numbers (e.g., "0-0") to Seat objects for direct access
    private final Map<String, Seat> seatsByNumber;

    // Nested map for position-based access (row → column → seat)
    private final Map<Integer,Map<Integer,Seat>> seatsByPosition;

    public Layout(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seatsByNumber = new HashMap<>();
        this.seatsByPosition = new HashMap<>();
        initializeLayout();
    }
    private void initializeLayout() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String seatNumber = i + "-" + j;
                addSeat(seatNumber, i, j, new Seat(seatNumber, null));
            }
        }
    }
    public void addSeat(String seatNumber,int row,int col,Seat seat){
        // Store seat in number-based lookup map
        seatsByNumber.put(seatNumber,seat);
        // Store seat in position-based lookup map
        seatsByPosition.computeIfAbsent(row,k->new HashMap<>()).put(col,seat);
    }
    public Seat getSeatByNumber(String seatNumber) {
        return seatsByNumber.get(seatNumber);
    }

    public Seat getSeatByPosition(int row, int col) {
        Map<Integer, Seat> rowSeats = seatsByPosition.get(row);
        return (rowSeats != null) ? rowSeats.get(col) : null;
    }
    public List<Seat> getAllSeats(){
        return List.copyOf(seatsByNumber.values());
    }
}
//Layout integrates with the Room class to provide the seating structure,
// working alongside Seat objects to support the ticket booking process, such as availability and pricing.
//An alternative could be a 2D array (Seat[][]) for the grid, which is simpler for fixed-size layouts and offers direct index-based access.
//However, arrays lack flexibility for irregular layouts (e.g., missing seats) and require pre-allocation.


