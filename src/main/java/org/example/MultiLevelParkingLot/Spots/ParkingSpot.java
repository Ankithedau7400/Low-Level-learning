package org.example.MultiLevelParkingLot.Spots;

import org.example.MultiLevelParkingLot.Vehicle.Vehicle;
import org.example.ParkingLot.VehicleSize;

/**
 * Interface representing a parking spot in a multi-level parking lot.
 * Defines the contract that all parking spot implementations must follow.
 * Each spot can be either available or occupied by a vehicle.
 */
public interface ParkingSpot {
    boolean isAvailable();

    void occupy(Vehicle vehicle);

    void vacate();

    int getSpotNumber();

    VehicleSize getSize();

    Vehicle getOccupyingVehicle();

}

