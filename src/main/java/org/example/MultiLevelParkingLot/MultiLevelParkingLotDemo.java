package org.example.MultiLevelParkingLot;

import org.example.MultiLevelParkingLot.Vehicle.Vehicle;

/**
 * Demo class showing how to use the Multi-Level Parking Lot system.
 * This demonstrates the complete workflow from vehicle entry to exit with fare calculation.
 *
 * Usage: java org.example.MultiLevelParkingLot.MultiLevelParkingLotDemo
 */
public class MultiLevelParkingLotDemo {

    public static void main(String[] args) {
        System.out.println("===== Multi-Level Parking Lot System Demo =====\n");

        // Create a multi-level parking lot with 3 levels and 5 spots per size per level
        MultiLevelParkingLotFactory factory = new MultiLevelParkingLotFactory();
        MultiLevelParkingLot parkingLot = factory.createMultiLevelParkingLot(3, 5);

        System.out.println("✓ Created parking lot with " + parkingLot.getTotalLevels() + " levels");
        System.out.println("✓ Total available spots: " + parkingLot.getTotalAvailableSpots() + "\n");

        // Display initial status
        System.out.println(parkingLot.getParkingLotStatus());

        // Test 1: Park a car
        System.out.println("\n--- Test 1: Parking a Car ---");
        Vehicle car1 = factory.createVehicle("car", "CAR-001");
        MultiLevelTicket ticket1 = parkingLot.entryVehicle(car1);
        if (ticket1 != null) {
            System.out.println("✓ Car parked successfully!");
            System.out.println("  " + ticket1.getTicketInfo());
            System.out.println("  Available spots now: " + parkingLot.getTotalAvailableSpots());
        }

        // Test 2: Park a motorcycle
        System.out.println("\n--- Test 2: Parking a Motorcycle ---");
        Vehicle motorcycle1 = factory.createVehicle("motorcycle", "MOTO-001");
        MultiLevelTicket ticket2 = parkingLot.entryVehicle(motorcycle1);
        if (ticket2 != null) {
            System.out.println("✓ Motorcycle parked successfully!");
            System.out.println("  " + ticket2.getTicketInfo());
            System.out.println("  Available spots now: " + parkingLot.getTotalAvailableSpots());
        }

        // Test 3: Park a truck
        System.out.println("\n--- Test 3: Parking a Truck ---");
        Vehicle truck1 = factory.createVehicle("truck", "TRUCK-001");
        MultiLevelTicket ticket3 = parkingLot.entryVehicle(truck1);
        if (ticket3 != null) {
            System.out.println("✓ Truck parked successfully!");
            System.out.println("  " + ticket3.getTicketInfo());
            System.out.println("  Available spots now: " + parkingLot.getTotalAvailableSpots());
        }

        // Display status after parking multiple vehicles
        System.out.println("\n" + parkingLot.getParkingLotStatus());

        // Simulate delay (in real scenario, this would be parking duration)
        System.out.println("\n--- Simulating parking duration (2 seconds) ---");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Test 4: Vehicle exit and fare calculation
        System.out.println("\n--- Test 4: Car Exit and Fare Calculation ---");
        parkingLot.leaveVehicle(ticket1);
        System.out.println("✓ Available spots now: " + parkingLot.getTotalAvailableSpots());

        // Test 5: Another vehicle exit
        System.out.println("\n--- Test 5: Motorcycle Exit ---");
        parkingLot.leaveVehicle(ticket2);
        System.out.println("✓ Available spots now: " + parkingLot.getTotalAvailableSpots());

        // Display final status
        System.out.println("\n" + parkingLot.getParkingLotStatus());

        // Test 6: Invalid ticket handling
        System.out.println("\n--- Test 6: Invalid Ticket Handling ---");
        MultiLevelTicket invalidTicket = null;
        parkingLot.leaveVehicle(invalidTicket);

        // Final summary
        System.out.println("\n===== Demo Complete =====");
        System.out.println("Final available spots: " + parkingLot.getTotalAvailableSpots());
        System.out.println("Parking lot full: " + parkingLot.isParkingLotFull());
    }
}

