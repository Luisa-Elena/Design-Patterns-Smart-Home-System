package org.example.observer;

import org.example.strategy.HeatPump;

import java.util.ArrayList;

public class Room {
    private ArrayList<Subscriber> subscribers;
    private boolean isEmpty;

    private HeatPump heatPump;

    public Room() {
        this.isEmpty = false;
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

    public void notifySubscribers(boolean empty) {
        for(Subscriber subscriber : this.subscribers) {
            subscriber.update(empty);
        }
    }

    public HeatPump getHeatPump() {
        return heatPump;
    }

    public void setHeatPump(HeatPump heatPump) {
        this.heatPump = heatPump;
    }

    public ArrayList<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        if(empty != this.isEmpty) {
            notifySubscribers(this.isEmpty);
        }
        isEmpty = empty;
    }
}
