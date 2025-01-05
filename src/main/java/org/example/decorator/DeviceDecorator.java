package org.example.decorator;

import org.example.bridge.Device;
import org.example.memento.Memento;

public class DeviceDecorator implements Device {
    private Device wrappee;

    public DeviceDecorator(Device wrappee) {
        this.wrappee = wrappee;
    }

    public void setWrappee(Device wrappee) { this.wrappee = wrappee; }

    @Override
    public boolean isEnabled() {
        return wrappee.isEnabled();
    }

    @Override
    public void enable() {
        wrappee.enable();
    }

    @Override
    public void disable() {
        wrappee.disable();
    }

    @Override
    public int getVolume() {
        return wrappee.getVolume();
    }

    @Override
    public void setVolume(int volume) {
        wrappee.setVolume(volume);
    }

    @Override
    public int getChannel() {
        return wrappee.getChannel();
    }

    @Override
    public void setChannel(int channel) {
        wrappee.setChannel(channel);
    }

    @Override
    public int getMaxChannel() {
        return wrappee.getMaxChannel();
    }

    @Override
    public int getMaxVolume() {
        return wrappee.getMaxVolume();
    }

    @Override
    public Memento save() { return wrappee.save(); }

    @Override
    public void restore(Memento m) { wrappee.restore(m); }
}
