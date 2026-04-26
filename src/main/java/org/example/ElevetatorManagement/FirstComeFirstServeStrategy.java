package org.example.ElevetatorManagement;

import java.util.List;

public class FirstComeFirstServeStrategy implements DispatchingStrategy{
    @Override
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction) {

        for(ElevatorCar elevatorCar: elevators){
            if(elevatorCar.isIdle() || elevatorCar.getStatus().getDirection() == direction && ((direction == Direction.UP && elevatorCar.getStatus().getCurrentFloor() <= floor) || (direction == Direction.DOWN && elevatorCar.getStatus().getCurrentFloor() >= floor))){
                return elevatorCar;
            }
        }
        return elevators.get((int) (Math.random() * elevators.size()));
    }
}
