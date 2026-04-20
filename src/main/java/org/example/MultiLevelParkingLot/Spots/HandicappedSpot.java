package org.example.MultiLevelParkingLot.Spots;

import org.example.MultiLevelParkingLot.Vehicle.Vehicle;
import org.example.ParkingLot.VehicleSize;

/**
 * Represents a handicapped/accessible parking spot.
 * Reserved for vehicles with proper handicapped permits.
 * Usually located on ground levels for easier accessibility.
 */
public class HandicappedSpot implements ParkingSpot {
    private final int spotNumber;
    private Vehicle vehicle;
    private final boolean isReserved;


    public HandicappedSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicle = null;
        this.isReserved = true;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (isAvailable()) {
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
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;
    }

    @Override
    public Vehicle getOccupyingVehicle() {
        return vehicle;
    }


    public boolean isHandicappedReserved() {
        return isReserved;
    }
}

