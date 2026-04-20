package org.example.MultiLevelParkingLot;

import org.example.MultiLevelParkingLot.Spots.*;
import org.example.MultiLevelParkingLot.Vehicle.*;
import org.example.ParkingLot.FareCa.BaseFareStrategy;
import org.example.ParkingLot.FareCa.FareCalculator;
import org.example.ParkingLot.FareCa.PeakHoursFareStrategy;
import org.example.ParkingLot.VehicleSize;

import java.util.*;

/**
 * Factory class for creating and initializing a multi-level parking lot.
 * Demonstrates how to set up a complete multi-level parking lot system
 * with multiple levels, different spot types, and fare strategies.
 *
 * Example usage:
 * MultiLevelParkingLotFactory factory = new MultiLevelParkingLotFactory();
 * MultiLevelParkingLot parkingLot = factory.createMultiLevelParkingLot(3, 10);
 */
public class MultiLevelParkingLotFactory {

    /**
     * Creates a multi-level parking lot with specified number of levels
     * and spots per level.
     *
     * @param numLevels Number of parking levels
     * @param spotsPerLevelPerSize Number of spots per vehicle size per level
     * @return Initialized MultiLevelParkingLot ready for use
     */
    public MultiLevelParkingLot createMultiLevelParkingLot(int numLevels, int spotsPerLevelPerSize) {
        // Create all levels
        List<Level> levels = new ArrayList<>();
        for (int i = 1; i <= numLevels; i++) {
            Level level = createLevel(i, spotsPerLevelPerSize);
            levels.add(level);
        }

        // Create MultiLevelManager
        MultiLevelManager manager = new MultiLevelManager(levels);

        // Create FareCalculator with strategies
        List<org.example.ParkingLot.FareCa.FareStrategy> strategies = new ArrayList<>();
        strategies.add(new BaseFareStrategy());
        strategies.add(new PeakHoursFareStrategy());
        FareCalculator fareCalculator = new FareCalculator(strategies);

        // Return the multi-level parking lot
        return new MultiLevelParkingLot(manager, fareCalculator);
    }

    /**
     * Creates a single level with parking spots for all vehicle sizes.
     * Distributes spots as: 30% compact, 50% regular, 20% oversized.
     *
     * @param levelNumber The level number/identifier
     * @param spotsPerSize Number of spots for each vehicle size
     * @return Initialized Level
     */
    private Level createLevel(int levelNumber, int spotsPerSize) {
        Map<VehicleSize, List<ParkingSpot>> spotMap = new HashMap<>();

        // Create compact spots (SMALL)
        List<ParkingSpot> compactSpots = new ArrayList<>();
        for (int i = 0; i < spotsPerSize; i++) {
            compactSpots.add(new CompactSpot(levelNumber * 1000 + 100 + i));
        }
        spotMap.put(VehicleSize.SMALL, compactSpots);

        // Create regular spots (MEDIUM)
        List<ParkingSpot> regularSpots = new ArrayList<>();
        for (int i = 0; i < spotsPerSize; i++) {
            regularSpots.add(new RegularSpot(levelNumber * 1000 + 200 + i));
        }
        spotMap.put(VehicleSize.MEDIUM, regularSpots);

        // Create oversized spots (LARGE)
        List<ParkingSpot> oversizedSpots = new ArrayList<>();
        for (int i = 0; i < spotsPerSize; i++) {
            oversizedSpots.add(new OversizedSpot(levelNumber * 1000 + 300 + i));
        }
        spotMap.put(VehicleSize.LARGE, oversizedSpots);

        return new Level(levelNumber, spotMap);
    }

    /**
     * Creates a sample vehicle for testing purposes.
     *
     * @param vehicleType Type of vehicle ("car", "motorcycle", "truck")
     * @param licensePlate License plate number
     * @return Vehicle instance
     */
    public Vehicle createVehicle(String vehicleType, String licensePlate) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return new Car(licensePlate);
            case "motorcycle":
                return new Motorcycle(licensePlate);
            case "truck":
                return new Truck(licensePlate);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}

