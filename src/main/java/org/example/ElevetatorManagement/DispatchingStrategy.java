package org.example.ElevetatorManagement;

import java.util.List;

public interface DispatchingStrategy {
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction);
}
