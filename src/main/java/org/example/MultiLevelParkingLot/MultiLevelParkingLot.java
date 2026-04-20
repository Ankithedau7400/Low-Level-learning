package org.example.MultiLevelParkingLot;

import org.example.MultiLevelParkingLot.Spots.ParkingSpot;
import org.example.MultiLevelParkingLot.Vehicle.Vehicle;
import org.example.ParkingLot.FareCa.FareCalculator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class MultiLevelParkingLot {
    private final MultiLevelManager multiLevelManager;
    private final FareCalculator fareCalculator;


    public MultiLevelParkingLot(MultiLevelManager multiLevelManager, FareCalculator fareCalculator) {
        this.multiLevelManager = multiLevelManager;
        this.fareCalculator = fareCalculator;
    }


    public MultiLevelTicket entryVehicle(Vehicle vehicle) {
        ParkingSpot spot = multiLevelManager.parkVehicle(vehicle);
        if(spot != null){
            MultiLevelTicket ticket = new MultiLevelTicket(
                    generateTicketId(), vehicle, spot, LocalDateTime.now());
            return ticket;

        }
        return null;
    }


    public void leaveVehicle(MultiLevelTicket ticket) {
        if (ticket != null && ticket.getExitTime() == null) {
            // Set exit time
            ticket.setExitTime(LocalDateTime.now());

            // Unpark the vehicle from the level
            multiLevelManager.unparkVehicle(ticket.getVehicle());

            // Calculate fare using FareCalculator
            // Note: Creating a wrapper ticket for fare calculation with single-level Vehicle interface
            org.example.ParkingLot.Ticket singleLevelTicket =
                    new org.example.ParkingLot.Ticket(
                            ticket.getTicketId(),
                            convertToSingleLevelVehicle(ticket.getVehicle()),
                            convertToSingleLevelSpot(ticket.getParkingSpot()),
                            ticket.getEntryTime());
            BigDecimal fare = fareCalculator.calculateFare(singleLevelTicket);

            // Display payment information
            System.out.println("==================================");
            System.out.println("Vehicle Exit Receipt");
            System.out.println("==================================");
            System.out.println("Ticket ID: " + ticket.getTicketId());
            System.out.println("License Plate: " + ticket.getVehicle().getLicensePlate());

            System.out.println("Spot: " + ticket.getParkingSpot().getSpotNumber());
            System.out.println("Entry Time: " + ticket.getEntryTime());
            System.out.println("Exit Time: " + ticket.getExitTime());
            System.out.println("Duration: " + ticket.calculateParkingDuration() + " minutes");
            System.out.println("Total Fare: $" + fare);
            System.out.println("==================================");
        } else {
            System.out.println("Invalid ticket or vehicle already exited.");
        }
    }




    private String generateTicketId() {
        return "TICKET-" + System.currentTimeMillis();
    }


     private org.example.ParkingLot.Vehicle.Vehicle convertToSingleLevelVehicle(Vehicle multiLevelVehicle) {
         return new org.example.ParkingLot.Vehicle.Vehicle() {
             @Override
             public String getLicensePlate() {
                 return multiLevelVehicle.getLicensePlate();
             }

             @Override
             public org.example.ParkingLot.VehicleSize getSize() {
                 return multiLevelVehicle.getSize();
             }
         };
     }

     /**
      * Converts multi-level ParkingSpot to single-level ParkingSpot interface for compatibility.
      *
      * @param multiLevelSpot ParkingSpot from multi-level system
      * @return Single-level ParkingSpot interface
      */
     private org.example.ParkingLot.Spots.ParkingSpot convertToSingleLevelSpot(ParkingSpot multiLevelSpot) {
         return new org.example.ParkingLot.Spots.ParkingSpot() {
             @Override
             public boolean isAvailable() {
                 return multiLevelSpot.isAvailable();
             }

             @Override
             public void occupy(org.example.ParkingLot.Vehicle.Vehicle vehicle) {
             }

             @Override
             public void vacate() {
                 multiLevelSpot.vacate();
             }

             @Override
             public int getSpotNumber() {
                 return multiLevelSpot.getSpotNumber();
             }

             @Override
             public org.example.ParkingLot.VehicleSize getSize() {
                 return multiLevelSpot.getSize();
             }
         };
     }

     public String getParkingLotStatus() {
         return multiLevelManager.getOccupancyStatus();
     }


    public int getTotalAvailableSpots() {
        return multiLevelManager.getTotalAvailableSpots();
    }

    public boolean isParkingLotFull() {
        return multiLevelManager.isFull();
    }


    public int getTotalLevels() {
        return multiLevelManager.getTotalLevels();
    }
}

