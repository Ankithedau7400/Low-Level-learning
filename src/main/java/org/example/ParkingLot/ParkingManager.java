package org.example.ParkingLot;

import org.example.ParkingLot.Spots.ParkingSpot;
import org.example.ParkingLot.Vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {

    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicleToSpotMap;
    private final Map<ParkingSpot, Vehicle> spotToVehicleMap;


    public ParkingManager(Map<VehicleSize, List<ParkingSpot>> availableSpots) {
        this.availableSpots = availableSpots;
        this.spotToVehicleMap = new HashMap<>();
        this.vehicleToSpotMap = new HashMap<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle){
        VehicleSize vehicleSize = vehicle.getSize();
        for(VehicleSize size : VehicleSize.values()){
            if(size.ordinal() >= vehicleSize.ordinal()){
                List<ParkingSpot> spots = availableSpots.get(size);
                for (ParkingSpot spot : spots) {
                    if (spot.isAvailable()) {
                        return spot; // Return the first available spot
                    }
                }

            }
        }
        return null;// No suitable spot found
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findSpotForVehicle(vehicle);
        if(spot != null){
            spot.occupy(vehicle);
            vehicleToSpotMap.put(vehicle, spot);
            spotToVehicleMap.put(spot, vehicle);
            availableSpots.get(spot.getSize()).remove(spot);
        }
        return spot;
    }
//    Assigns a parking spot to the vehicle by calling findSpotForVehicle() and then marks it as occupied via occupy().
//    Records the vehicle-spot pair and removes the spot from the available pool, ensuring accurate tracking and availability updates.

    public void unparkVehicle(Vehicle vehicle){
        if(vehicleToSpotMap.containsKey(vehicle)){
            ParkingSpot spot = vehicleToSpotMap.get(vehicle);
            if(spot != null){
                spot.vacate();
                availableSpots.get(spot.getSize()).add(spot);
            }
        }
    }

//    Retrieves the parking spot for the given vehicle, frees the spot via vacate(), and adds it back to the available pool.
//    Removes the vehicle-spot mapping, keeping the system’s state current for future allocations.

    // Find vehicle's parking spot
    public ParkingSpot findVehicleBySpot(Vehicle vehicle) {
        return vehicleToSpotMap.get(vehicle);
    }
    // Find which vehicle is parked in a spot
    public Vehicle findSpotByVehicle(ParkingSpot spot) {
        return spotToVehicleMap.get(spot);
    }

}
