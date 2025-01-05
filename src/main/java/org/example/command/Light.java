package org.example.command;

import org.example.observer.Subscriber;

public class Light implements Subscriber {
    private boolean on;
    private int intensity;

    public Light() {
        this.on = false;
        this.intensity = 1;
    }

    public boolean isOn() {
        return this.on;
    }

    public int getIntensity() {
        System.out.println("Light intensity is " + this.intensity);
        return this.intensity;
    }

    public void setOn(boolean on) {
        this.on = on;
        if(on) {
            System.out.println("Light is on");
        } else {
            System.out.println("Light is off.");
        }
    }

    public void setIntensity(int intensity) {
        if(intensity >= 1 && intensity <= 20) {
            this.intensity = intensity;
            System.out.println("Light intensity is set to " + intensity);
        } else {
            System.out.println("Invalid light intensity value.");
        }
    }

    @Override
    public void update(boolean isRoomEmpty) {
        setOn(isRoomEmpty);
    }
}
