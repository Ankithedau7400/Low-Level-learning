package org.example.ElevetatorManagement;

import java.util.ArrayList;
import java.util.List;

public class HallwayButtonPanel {


    private final int floor;
    private final List<ElevatorObserver> observers;

    public HallwayButtonPanel(int floor) {
        this.floor = floor;
        this.observers = new ArrayList<>();
    }

    // Handles button press event and notifies all registered observers
    public void pressButton(Direction direction) {
        notifyObservers(direction);
    }
    // Notifies all registered observers about the button press
    private void notifyObservers(Direction direction) {
        for (ElevatorObserver observer : observers) {
            observer.update(floor, direction);
        }
    }
    public void addObserver(ElevatorObserver observer) {
        observers.add(observer);
    }
}
