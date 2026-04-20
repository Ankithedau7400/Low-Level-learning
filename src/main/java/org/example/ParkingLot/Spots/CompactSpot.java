package org.example.ParkingLot.Spots;

import org.example.ParkingLot.Vehicle.Vehicle;
import org.example.ParkingLot.VehicleSize;

public class CompactSpot implements ParkingSpot {
    private int spotNumber;
    private Vehicle vehicle;

    public CompactSpot(int spotNumber){
        this.spotNumber = spotNumber;
        vehicle = null;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if(isAvailable()){
            this.vehicle = vehicle;
        }else{
            this.vehicle = null;
            // Spot already occupied
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
        return  VehicleSize.SMALL;
    }
}
