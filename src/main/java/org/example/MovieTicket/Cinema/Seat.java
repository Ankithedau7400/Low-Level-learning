package org.example.MovieTicket.Cinema;

import org.example.MovieTicket.PricingStrategy.PricingStrategy;

public class Seat {
    private final String seatNumber;
    private PricingStrategy pricingStrategy;

    public Seat(String seatNumber, PricingStrategy pricingStrategy) {
        this.seatNumber = seatNumber;
        this.pricingStrategy = pricingStrategy;
    }
    public PricingStrategy getPricingStrategy(){
        return pricingStrategy;
    }

    public String getSeatNumber(){
        return seatNumber;
    }

}
