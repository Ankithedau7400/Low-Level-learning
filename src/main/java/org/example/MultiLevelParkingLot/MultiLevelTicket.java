package org.example.MultiLevelParkingLot;

import org.example.MultiLevelParkingLot.Spots.ParkingSpot;
import org.example.MultiLevelParkingLot.Vehicle.Vehicle;
import org.example.ParkingLot.FareCa.FareCalculator;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class MultiLevelTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;
    public LocalDateTime exitTime;


    public MultiLevelTicket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot,
                    LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
        this.exitTime = null; // Vehicle is still parked
    }


    public BigDecimal calculateParkingDuration() {
        return new BigDecimal(
                java.time.Duration.between(
                        entryTime,
                        java.util.Objects.requireNonNullElseGet(exitTime, LocalDateTime::now))
                        .toMinutes());
    }

    // Getters
    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }



    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getTicketInfo() {
        return "Ticket ID: " + ticketId +
                ", Vehicle: " + vehicle.getLicensePlate() +

                ", Spot: " + parkingSpot.getSpotNumber() +
                ", Entry: " + entryTime;
    }
}

