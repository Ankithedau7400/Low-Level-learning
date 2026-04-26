package org.example.ElevetatorManagement;

import java.util.List;

public class ShortestSeekTimeFirstStrategy implements DispatchingStrategy{
    @Override
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction) {
        ElevatorCar bestElevator = null;
        int shortestDistance = Integer.MAX_VALUE;

        for(ElevatorCar elevatorCar: elevators){
            int distance = Math.abs(elevatorCar.getStatus().getCurrentFloor()-floor);

            if(elevatorCar.isIdle() || elevatorCar.getStatus().getDirection() == direction && ((direction == Direction.UP && elevatorCar.getStatus().getCurrentFloor() <= floor) || (direction == Direction.DOWN && elevatorCar.getStatus().getCurrentFloor() >= floor))
                    && elevatorCar.getAccessibleFloors().contains(floor)){
                if(distance < shortestDistance){
                    shortestDistance = distance;
                    bestElevator = elevatorCar;
                }
            }

        }
        return bestElevator;
    }
}
