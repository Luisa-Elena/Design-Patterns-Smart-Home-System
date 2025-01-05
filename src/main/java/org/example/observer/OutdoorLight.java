package org.example.observer;

public class OutdoorLight implements Subscriber {
    private boolean onOff;

    public OutdoorLight(boolean onOff) {
        this.onOff = onOff;
    }

    @Override
    public void update(boolean alertState) {
        this.onOff = alertState;
        if(alertState) {
            System.out.println("Outdoor light is on.");
        } else {
            System.out.println("Outdoor light is off.");
        }
    }
}
