package org.example.MultiLevelParkingLot;

import org.example.MultiLevelParkingLot.Spots.ParkingSpot;
import org.example.MultiLevelParkingLot.Vehicle.Vehicle;
import org.example.ParkingLot.VehicleSize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a single level/floor in a multi-level parking lot.
 * Each level contains parking spots organized by vehicle size.
 * This class manages the parking operations for a specific level.
 */
public class Level {
    private final int levelNumber;
    private final Map<VehicleSize,List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicleToSpotMap;


    public Level(int levelNumber, Map<VehicleSize, List<ParkingSpot>> availableSpots) {
        this.levelNumber = levelNumber;
        this.availableSpots = availableSpots;
        this.vehicleToSpotMap = new HashMap<>();
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle){
        VehicleSize vehicleSize = vehicle.getSize();
        for(VehicleSize size: VehicleSize.values()){
            if(size.ordinal() >= vehicleSize.ordinal()){
                List<ParkingSpot> spots = availableSpots.get(size);
                if(spots != null && !spots.isEmpty()){
                    for(ParkingSpot spot: spots){
                        if(spot.isAvailable()){
                            return spot;
                        }
                    }
                }
            }
        }
        return null;
    }



    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot  = findAvailableSpot(vehicle);
        if(spot!=null){
            spot.occupy(vehicle);
            vehicleToSpotMap.put(vehicle,spot);
            availableSpots.get(spot.getSize()).remove(spot);
        }
        return spot;
    }

    public void unparkVehicle(Vehicle vehicle){
        if(vehicleToSpotMap.containsKey(vehicle)){
            ParkingSpot spot = vehicleToSpotMap.get(vehicle);
            if(spot!=null){
                spot.vacate();
                availableSpots.get(spot.getSize()).add(spot);
                vehicleToSpotMap.remove(vehicle);
            }
        }
    }


    public int getLevelNumber() {
        return levelNumber;
    }

    public ParkingSpot getSpotForVehicle(Vehicle vehicle) {
        return vehicleToSpotMap.get(vehicle);
    }

    public boolean hasAvailableSpots(){
        for (List<ParkingSpot> spots : availableSpots.values()) {
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable()) {
                    return true;
                }
            }
        }
        return false;
    }
    public int getAvailableSpotCount(VehicleSize size){
        List<ParkingSpot> spots = availableSpots.get(size);
        if (spots == null) return 0;

        int count =0;
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                count++;
            }
        }
        return count;
    }


}

