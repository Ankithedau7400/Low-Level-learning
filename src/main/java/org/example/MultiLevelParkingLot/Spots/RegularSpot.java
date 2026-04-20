package org.example.MultiLevelParkingLot.Spots;

import org.example.MultiLevelParkingLot.Vehicle.Vehicle;
import org.example.ParkingLot.VehicleSize;

/**
 * Represents a regular parking spot designed for standard vehicles.
 * Can accommodate cars and small SUVs.
 * Most common spot type in the parking lot.
 */
public class RegularSpot implements ParkingSpot {
    private final int spotNumber;
    private Vehicle vehicle;

    public RegularSpot(int spotNumber)
    {
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }
    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }
    @Override
    public void occupy(Vehicle vehicle) {
        if(isAvailable()){
            this.vehicle = vehicle;
        }
    }
    @Override
    public void vacate() {
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber() {
        return spotNumber;
    }
    @Override
    public VehicleSize getSize(){
        return VehicleSize.MEDIUM;
    }
    @Override
    public Vehicle getOccupyingVehicle() {
        return vehicle;
    }

}

