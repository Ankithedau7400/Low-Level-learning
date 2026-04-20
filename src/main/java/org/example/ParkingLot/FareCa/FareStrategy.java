package org.example.ParkingLot.FareCa;

import org.example.ParkingLot.Ticket;

import java.math.BigDecimal;

public interface FareStrategy {
    BigDecimal calculateFare(Ticket ticket, BigDecimal inputFare);
}
