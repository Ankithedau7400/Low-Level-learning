package org.example.MultiLevelParkingLot.Vehicle;

import org.example.ParkingLot.VehicleSize;

/**
 * Represents a motorcycle vehicle type in the parking lot system.
 * Motorcycles are classified as SMALL sized vehicles.
 * Can fit in compact, regular, and oversized parking spots.
 */
public class Motorcycle implements Vehicle {
    private final String licensePlate;

    public Motorcycle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.SMALL;
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "licensePlate='" + licensePlate + '\'' +
                '}';
    }
}

