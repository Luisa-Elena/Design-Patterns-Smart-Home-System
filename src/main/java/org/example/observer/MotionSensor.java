package org.example.observer;

import java.util.ArrayList;

public class MotionSensor {
    private ArrayList<Subscriber> subscribers;
    private boolean alertState;

    public MotionSensor(boolean alertState) {
        this.alertState = alertState;
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber s) {
        this.subscribers.add(s);
    }

    public void removeSubscriber(Subscriber s) {
        for(Subscriber subscriber : this.subscribers) {
            if(subscriber == s) {
                this.subscribers.remove(s);
            }
        }
    }

    public void notifySubscribers(boolean alertState) {
        for(Subscriber subscriber : this.subscribers) {
            subscriber.update(alertState);
        }
    }

    public ArrayList<Subscriber> getSubscribers() {
        return subscribers;
    }

    public boolean isAlertState() {
        return alertState;
    }

    public void setSubscribers(ArrayList<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public void setAlertState(boolean alertState) {

        System.out.println("----- Alert state is " + alertState);
        notifySubscribers(alertState);
        this.alertState = alertState;
    }
}
