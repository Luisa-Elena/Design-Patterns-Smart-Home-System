package org.example.observer;

public class DoorLock implements Subscriber {
    private boolean locked;

    public DoorLock(boolean locked) {
        this.locked = locked;
    }

    @Override
    public void update(boolean alertState) {
        this.locked = alertState;
        if(alertState) {
            System.out.println("Door is locked.");
        } else {
            System.out.println("Door is not locked.");
        }
    }
}
