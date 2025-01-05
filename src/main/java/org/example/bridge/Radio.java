package org.example.bridge;

import org.example.memento.Memento;

public class Radio implements Device {
    private boolean enabled;
    private int volume;
    private int channel;

    public Radio() {
        this.enabled = false;
        this.volume = 0;
        this.channel = 0;
    }

    public int getMaxVolume() {
        return 20;
    }

    public int getMaxChannel() {
        return 50;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void enable() {
        this.enabled = true;
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
}
