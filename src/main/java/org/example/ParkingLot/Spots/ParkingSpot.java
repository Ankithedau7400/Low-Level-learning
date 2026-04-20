package org.example.ParkingLot.Spots;

import org.example.ParkingLot.Vehicle.Vehicle;
import org.example.ParkingLot.VehicleSize;

public interface ParkingSpot {
    boolean isAvailable();

    void occupy(Vehicle vehicle);

    void vacate();

    int getSpotNumber();

    VehicleSize getSize();
}
