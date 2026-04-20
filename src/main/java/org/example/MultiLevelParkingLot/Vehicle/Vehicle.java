package org.example.MultiLevelParkingLot.Vehicle;

import org.example.ParkingLot.VehicleSize;

/**
 * Interface representing a vehicle in the parking lot system.
 * Defines the contract that all vehicle types must follow.
 * Provides information about the vehicle needed for parking operations.
 */
public interface Vehicle {

    String getLicensePlate();

    VehicleSize getSize();


    String getVehicleType();
}

