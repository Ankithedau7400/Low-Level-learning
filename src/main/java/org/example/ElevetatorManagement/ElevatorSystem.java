package org.example.ElevetatorManagement;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private final List<ElevatorCar> elevators;
    private final ElevatorDispatch dispatchController;

    public ElevatorSystem(List<ElevatorCar> elevators, DispatchingStrategy strategy) {
        this.elevators = elevators;
        this.dispatchController = new ElevatorDispatch(strategy);
    }
    // Returns the current status of all elevators in the system
    public List<ElevatorStatus> getAllElevatorStatuses() {
        List<ElevatorStatus> statuses = new ArrayList<>();
        for (ElevatorCar elevator : elevators) {
            statuses.add(elevator.getStatus());
        }
        return statuses;
    }
    //
    public void requestElevator(int currentFloor, Direction direction){
        dispatchController.dispatchElevatorCar(currentFloor, direction, elevators);
    }

    // Handles a floor selection request from inside an elevator
    public void selectFloor(ElevatorCar elevatorCar, int destinationFloor) {
        elevatorCar.addFloorRequest(destinationFloor);
    }

}
