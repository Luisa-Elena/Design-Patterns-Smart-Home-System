package org.example.bridge;

import org.example.memento.Memento;
import org.example.observer.Subscriber;

public class TV implements Device, Subscriber {
    private boolean enabled;
    private int volume;
    private int channel;
    private boolean brightness;

    public TV() {
        this.enabled = false;
        this.volume = 0;
        this.channel = 0;
        this.brightness = false;
    }

    public int getMaxVolume() {
        return 35;
    }

    public int getMaxChannel() {
        return 300;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void enable() {
        this.enabled = true;
        this.brightness = true;
    }

    @Override
    public void disable() {
        this.enabled = false;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int getChannel() {
        return this.channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public Memento save() {
        return new Memento(channel);
    }

    @Override
    public void restore(Memento m) {
        this.setChannel(m.getChannel());
    }

    @Override
    public void update(boolean isRoomEmpty) {
        this.brightness = !isRoomEmpty;
        if(this.brightness) {
            System.out.println("TV brightness is set to low.");
        } else {
            System.out.println("TV brightness is set to high.");
        }
    }
}
