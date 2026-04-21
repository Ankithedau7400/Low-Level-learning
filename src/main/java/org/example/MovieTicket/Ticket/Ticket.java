package org.example.MovieTicket.Ticket;

import org.example.MovieTicket.Cinema.Seat;
import org.example.MovieTicket.Screening.Screening;

import java.math.BigDecimal;

public class Ticket {
    private final Screening screening;
    private final Seat seat;
    private final BigDecimal price;

    public Ticket(Screening screening, Seat seat, BigDecimal price) {
        this.screening = screening;
        this.seat = seat;
        this.price = price;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public Seat getSeat() {
        return seat;
    }

}
