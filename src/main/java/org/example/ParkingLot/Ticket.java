package org.example.ParkingLot;

import org.example.ParkingLot.Spots.ParkingSpot;
import org.example.ParkingLot.Vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;


public class Ticket {
    private final String tickedId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    private final LocalDateTime entryTime;
    public LocalDateTime exitTime;

    public Ticket(
            String tickedId, Vehicle vehicle, ParkingSpot parkingSpot, LocalDateTime entryTime) {
        this.tickedId = tickedId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        // Initially, exitTime is null because the vehicle is still parked
         this.exitTime = null;
    }
    public BigDecimal calculateParkingDuration() {
        return new BigDecimal(
                Duration.between(
                                entryTime,
                                Objects.requireNonNullElseGet(exitTime, LocalDateTime::now))
                        .toMinutes());
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getTickedId() {
        return tickedId;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    public void setExitTime(LocalDateTime localDateTime){
        this.exitTime = localDateTime;
    }
}
