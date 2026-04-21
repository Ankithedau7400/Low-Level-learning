package org.example.MovieTicket.Ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Ticket> tickets;
    private final LocalDateTime orderDate;

    public Order(LocalDateTime orderDate) {
        this.tickets = new ArrayList<>();
        this.orderDate = orderDate;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    public BigDecimal calculateTotalPrice() {
        return tickets.stream().map(Ticket::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

     public List<Ticket> getTickets() {
        return tickets;
    }

     public LocalDateTime getOrderDate() {
        return orderDate;
    }

}
