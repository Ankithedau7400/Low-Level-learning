package org.example.MultiLevelParkingLot.Vehicle;

import org.example.ParkingLot.VehicleSize;

/**
 * Represents a truck vehicle type in the parking lot system.
 * Trucks are classified as LARGE sized vehicles.
 * Can only fit in oversized parking spots.
 */
public class Truck implements Vehicle {
    private final String licensePlate;

    public Truck(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.LARGE;
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }

    @Override
    public String toString() {
        return "Truck{" +
                "licensePlate='" + licensePlate + '\'' +
                '}';
    }
}

