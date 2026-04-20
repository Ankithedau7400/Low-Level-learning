package org.example.MultiLevelParkingLot.Vehicle;

import org.example.ParkingLot.VehicleSize;

/**
 * Represents a car vehicle type in the parking lot system.
 * Cars are classified as MEDIUM sized vehicles.
 * Can fit in regular and oversized parking spots.
 */
public class Car implements Vehicle {
    private final String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                '}';
    }
}

