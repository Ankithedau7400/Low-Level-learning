package org.example.ParkingLot;

import org.example.ParkingLot.FareCa.FareCalculator;
import org.example.ParkingLot.Spots.ParkingSpot;
import org.example.ParkingLot.Vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkingLot {
    private final ParkingManager parkingManager;
    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator) {
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;
    }

    public Ticket entryVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = parkingManager.parkVehicle(vehicle);
        if(parkingSpot!=null){
            Ticket ticket =  new Ticket(LocalDateTime.now().toString(), vehicle, parkingSpot, LocalDateTime.now());
            return ticket;
        }
        return null; // No spot available
    }

    public void leaveVehicle(Ticket ticket){
        if(ticket  != null && ticket.getExitTime() == null){
            // Set exit time
            ticket.setExitTime(LocalDateTime.now());

            // Delegate unparking logic to ParkingManager
            parkingManager.unparkVehicle(ticket.getVehicle());

            // Calculate fare using FareCalculator
            BigDecimal fare = fareCalculator.calculateFare(ticket);
            System.out.println("Total fare for ticket " + ticket.getTickedId() + ": " + fare);
        }else{
            // Invalid ticket or vehicle already exited.
        }
    }

}
