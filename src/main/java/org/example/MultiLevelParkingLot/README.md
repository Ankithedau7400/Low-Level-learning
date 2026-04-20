# Multi-Level Parking Lot System

## Overview
A comprehensive low-level design implementation of a multi-level parking lot system that manages vehicle parking operations across multiple floors/levels with proper fare calculation and occupancy tracking.

## Package Structure

```
org.example.MultiLevelParkingLot/
├── MultiLevelParkingLot.java          # Main facade for parking lot operations
├── MultiLevelManager.java             # Manages multiple levels
├── Level.java                         # Represents a single parking level
├── MultiLevelTicket.java              # Parking ticket with level information
├── MultiLevelParkingLotFactory.java   # Factory for creating parking lot instances
├── MultiLevelParkingLotDemo.java      # Demo/usage examples
├── Spots/                             # Parking spot implementations
│   ├── ParkingSpot.java              # Interface for parking spots
│   ├── CompactSpot.java              # Small parking spots (motorcycles)
│   ├── RegularSpot.java              # Medium parking spots (cars)
│   ├── OversizedSpot.java            # Large parking spots (trucks)
│   └── HandicappedSpot.java          # Accessible parking spots
└── Vehicle/                           # Vehicle type implementations
    ├── Vehicle.java                  # Interface for vehicles
    ├── Car.java                      # Car vehicle type
    ├── Motorcycle.java               # Motorcycle vehicle type
    └── Truck.java                    # Truck vehicle type
```

## Core Classes and Their Responsibilities

### 1. **MultiLevelParkingLot** (Main Facade)
**What it does:** Central entry point for all parking lot operations.
- **Key Methods:**
  - `entryVehicle(Vehicle)` - Processes vehicle entry and issues tickets
  - `leaveVehicle(MultiLevelTicket)` - Processes vehicle exit and calculates fare
  - `getParkingLotStatus()` - Returns occupancy information
  - `getTotalAvailableSpots()` - Gets available parking count
  - `isParkingLotFull()` - Checks if lot is at capacity

### 2. **MultiLevelManager**
**What it does:** Coordinates operations across all levels of the parking lot.
- **Key Methods:**
  - `findLevelForVehicle(Vehicle)` - Selects appropriate level for parking
  - `parkVehicle(Vehicle)` - Parks vehicle in the best available spot
  - `unparkVehicle(Vehicle)` - Removes vehicle from parking
  - `getTotalAvailableSpots()` - Counts available spots across all levels
  - `getOccupancyStatus()` - Displays status of all levels

### 3. **Level**
**What it does:** Manages parking operations for a single floor/level.
- **Key Methods:**
  - `findAvailableSpot(Vehicle)` - Finds suitable parking spot for vehicle
  - `parkVehicle(Vehicle)` - Assigns vehicle to a spot on this level
  - `unparkVehicle(Vehicle)` - Removes vehicle from this level
  - `hasAvailableSpots()` - Checks if this level has space
  - `getAvailableSpotCount(VehicleSize)` - Counts specific spot types

### 4. **MultiLevelTicket**
**What it does:** Represents a parking ticket with level and spot information.
- **Key Methods:**
  - `getTicketId()` - Retrieves ticket identifier
  - `getLevel()` - Gets the level where vehicle is parked
  - `getParkingSpot()` - Gets the assigned parking spot
  - `calculateParkingDuration()` - Calculates parking duration in minutes
  - `getTicketInfo()` - Returns formatted ticket information

### 5. **ParkingSpot Interface & Implementations**
**What it does:** Represents individual parking spaces with different sizes.
- **Implementations:**
  - **CompactSpot** - For small vehicles (motorcycles) - VehicleSize.SMALL
  - **RegularSpot** - For medium vehicles (cars) - VehicleSize.MEDIUM
  - **OversizedSpot** - For large vehicles (trucks) - VehicleSize.LARGE
  - **HandicappedSpot** - Accessible parking for disabled drivers

- **Key Methods:**
  - `isAvailable()` - Checks if spot is empty
  - `occupy(Vehicle)` - Assigns vehicle to spot
  - `vacate()` - Frees the spot
  - `getSize()` - Returns vehicle size category

### 6. **Vehicle Interface & Implementations**
**What it does:** Represents different vehicle types.
- **Implementations:**
  - **Car** - VehicleSize.MEDIUM (4-5 seaters)
  - **Motorcycle** - VehicleSize.SMALL (2 wheelers)
  - **Truck** - VehicleSize.LARGE (freight vehicles)

- **Key Methods:**
  - `getLicensePlate()` - Gets vehicle identifier
  - `getSize()` - Returns vehicle size category
  - `getVehicleType()` - Returns vehicle type name

### 7. **MultiLevelParkingLotFactory**
**What it does:** Factory for creating and initializing parking lot instances.
- **Key Methods:**
  - `createMultiLevelParkingLot(numLevels, spotsPerSize)` - Creates complete parking lot
  - `createVehicle(type, licensePlate)` - Creates vehicle instances
  - Handles all initialization logic

## Workflow: Vehicle Entry to Exit

### Entry Process
```
1. Vehicle arrives at entry gate
2. MultiLevelParkingLot.entryVehicle(vehicle) is called
3. MultiLevelManager searches for available level
4. Level searches for suitable spot by vehicle size
5. Spot is occupied by vehicle
6. MultiLevelTicket is issued with:
   - Ticket ID
   - Vehicle information
   - Spot and Level details
   - Entry timestamp
7. Ticket returned to driver
```

### Exit Process
```
1. Driver presents ticket at exit
2. MultiLevelParkingLot.leaveVehicle(ticket) is called
3. Exit time is recorded
4. Vehicle location is retrieved from ticket
5. Spot is vacated and made available
6. FareCalculator computes fare based on:
   - Parking duration
   - Vehicle size
   - Peak hour surcharge (if applicable)
   - Level surcharge (optional)
7. Payment receipt displayed with all details
8. Vehicle leaves parking lot
```

## Usage Example

```java
// Create factory
MultiLevelParkingLotFactory factory = new MultiLevelParkingLotFactory();

// Create 3-level parking lot with 10 spots per size per level
MultiLevelParkingLot parkingLot = factory.createMultiLevelParkingLot(3, 10);

// Create vehicles
Vehicle car = factory.createVehicle("car", "CAR-001");
Vehicle motorcycle = factory.createVehicle("motorcycle", "MOTO-001");

// Park vehicles
MultiLevelTicket ticket1 = parkingLot.entryVehicle(car);
MultiLevelTicket ticket2 = parkingLot.entryVehicle(motorcycle);

// Check status
System.out.println(parkingLot.getParkingLotStatus());

// Exit vehicle and pay
parkingLot.leaveVehicle(ticket1);
```

## Key Design Features

### Multi-Level Management
- Each level manages its own available spots
- Intelligent level selection for parking
- Support for any number of levels
- Individual level occupancy tracking

### Vehicle Size Categories
- **SMALL**: Motorcycles, scooters (most compact spots available)
- **MEDIUM**: Cars, SUVs (balanced spot availability)
- **LARGE**: Trucks, commercial vehicles (premium spots)

### Spot Types
- **Compact**: Best for small vehicles
- **Regular**: Standard parking for cars
- **Oversized**: For large vehicles
- **Handicapped**: Reserved/accessible parking

### Fare Calculation
- Base fare calculated on duration and vehicle size
- Peak hours multiplier (7-10 AM, 4-7 PM)
- Level surcharge for upper floors
- Extensible strategy pattern for custom calculations

### Occupancy Tracking
- Real-time spot availability
- Per-level statistics
- Cross-level aggregation
- Vehicle-to-level mapping
- Vehicle-to-spot mapping

## Configuration Options

### Creating Different Lot Sizes
```java
// Small lot: 2 levels, 5 spots each type
factory.createMultiLevelParkingLot(2, 5);

// Medium lot: 4 levels, 15 spots each type
factory.createMultiLevelParkingLot(4, 15);

// Large lot: 10 levels, 30 spots each type
factory.createMultiLevelParkingLot(10, 30);
```

## Extensions and Improvements

### Possible Enhancements
1. **Reservation System** - Pre-book parking spots
2. **Dynamic Pricing** - Real-time fare adjustments based on occupancy
3. **Electric Vehicle Charging** - Dedicated spots with charging stations
4. **Vehicle Validation** - Verify vehicle permits before entry
5. **Exit Gate Management** - Automated toll collection
6. **Floor-based Navigation** - Guide vehicles to available spots
7. **Maintenance Slots** - Reserve spots for lot maintenance
8. **Analytics** - Peak hour analysis, revenue reporting
9. **Mobile App Integration** - Find available spots, reserve, pay via app
10. **Security** - CCTV spot assignment, emergency vehicle routing

## Testing

Run the demo to see the system in action:
```bash
java org.example.MultiLevelParkingLot.MultiLevelParkingLotDemo
```

This will:
1. Create a 3-level parking lot
2. Park vehicles (car, motorcycle, truck)
3. Display occupancy status
4. Simulate vehicle exit with fare calculation
5. Show final occupancy status

