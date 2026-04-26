package org.example.ElevetatorManagement;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ElevatorCar {
    private ElevatorStatus status;
    private final Queue<Integer> targetFloors;
    private final Set<Integer> accessibleFloors;



    public ElevatorCar(int startingFloor, Set<Integer> accessibleFloors) {
        this.status = new ElevatorStatus(startingFloor, Direction.IDLE);
        this.accessibleFloors = accessibleFloors;
        this.targetFloors = new LinkedList<>();
    }
    // Returns the current state of the elevator
    public ElevatorStatus getStatus() {
        return status;
    }
    public boolean isIdle(){
        return status.getDirection() == Direction.IDLE && targetFloors.isEmpty();
    }
    public void addFloorRequest(int floor) {
        if (accessibleFloors.contains(floor) && !targetFloors.contains(floor)) {
            targetFloors.offer(floor);
            updateDirection(floor);
        }
    }

    private void updateDirection(int targetFloor){
        if(status.getCurrentFloor()<targetFloor){
            status.setCurrentFloor(Direction.UP);
        }else if(status.getCurrentFloor()<targetFloor){
            status.setCurrentFloor(Direction.DOWN);
        }
        else{
            status.setCurrentFloor(Direction.IDLE);
        }
    }
    public Set<Integer> getAccessibleFloors() {
        return accessibleFloors;
    }
}
