package org.example.MultiLevelParkingLot;

import org.example.MultiLevelParkingLot.Spots.ParkingSpot;
import org.example.MultiLevelParkingLot.Vehicle.Vehicle;
import org.example.ParkingLot.VehicleSize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiLevelManager {
    private final List<Level> levels;
    private final Map<Vehicle,Level> vehicleToLevelMap;


    public MultiLevelManager(List<Level> levels){
        this.levels = levels;
        vehicleToLevelMap = new HashMap<>();
    }
    public Level findLevelForVehicle(Vehicle vehicle){
        for(Level level: levels){
            if(level.hasAvailableSpots()){
                ParkingSpot spot = level.findAvailableSpot(vehicle);
                if(spot!=null){
                    return level;
                }
            }
        }
        return null;
    }
    public ParkingSpot parkVehicle(Vehicle vehicle){
        Level level = findLevelForVehicle(vehicle);
        if(level!=null){
            ParkingSpot spot = level.parkVehicle(vehicle);
            if(spot!=null) {
                vehicleToLevelMap.put(vehicle,level);
                return spot;
            }
        }
        return null;
    }
    public void unparkVehicle(Vehicle vehicle){
        if(vehicleToLevelMap.containsKey(vehicle)){
            Level level = vehicleToLevelMap.get(vehicle);
            level.unparkVehicle(vehicle);
            vehicleToLevelMap.remove(vehicle);
        }
    }

    public Level findLevelByVehicle(Vehicle vehicle){
        return vehicleToLevelMap.get(vehicle);
    }


    public int getTotalAvailableSpots() {
        int cnt = 0;
        for (Level level : levels) {
            cnt += level.getAvailableSpotCount(VehicleSize.SMALL);
            cnt += level.getAvailableSpotCount(VehicleSize.MEDIUM);
            cnt += level.getAvailableSpotCount(VehicleSize.LARGE);
        }
        return cnt;
    }


    public int getAvailableSpotCountBySize(VehicleSize size) {
        int cnt = 0;
        for (Level level : levels) {
            cnt += level.getAvailableSpotCount(size);
        }
        return cnt;
    }


    public boolean isFull() {
        for (Level level : levels) {
            if (level.hasAvailableSpots()) {
                return false;
            }
        }
        return true;
    }

    public int getTotalLevels() {
        return levels.size();
    }


    public String getOccupancyStatus() {
        StringBuilder status = new StringBuilder();
        status.append("=== Multi-Level Parking Lot Status ===\n");
        for (Level level : levels) {
            status.append("Level ").append(level.getLevelNumber()).append(": ");
            status.append("Small: ").append(level.getAvailableSpotCount(VehicleSize.SMALL)).append(", ");
            status.append("Medium: ").append(level.getAvailableSpotCount(VehicleSize.MEDIUM)).append(", ");
            status.append("Large: ").append(level.getAvailableSpotCount(VehicleSize.LARGE)).append("\n");
        }
        return status.toString();
    }
}

