package org.example.ElevetatorManagement;

public class ElevatorStatus {
    private int currentFloor;
    private Direction direction;

    public ElevatorStatus(int currentFloor, Direction direction) {
        this.currentFloor = currentFloor;
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setCurrentFloor(Direction direction){
        this.direction = direction;
    }
}
