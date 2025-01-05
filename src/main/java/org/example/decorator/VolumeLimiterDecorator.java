package org.example.decorator;

import org.example.bridge.Device;
import org.example.memento.Memento;

public class VolumeLimiterDecorator extends DeviceDecorator {
    private int voumeLimit;
    public VolumeLimiterDecorator(Device wrappee, int voumeLimit) {
        super(wrappee);
        this.voumeLimit = voumeLimit;
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }

    @Override
    public void enable() {
        super.enable();
    }

    @Override
    public void disable() {
        super.disable();
    }

    @Override
    public int getVolume() {
        return super.getVolume();
    }

    @Override
    public void setVolume(int volume) {
        if(volume > this.voumeLimit) {
            super.setVolume(voumeLimit);
            System.out.println("[LIMITER] Volume too high. Setting the volume to " + this.voumeLimit);
        } else {
            super.setVolume(volume);
        }
    }

    @Override
    public int getChannel() {
        return super.getChannel();
    }

    @Override
    public void setChannel(int channel) {
        super.setChannel(channel);
    }

    @Override
    public int getMaxChannel() {
        return super.getMaxChannel();
    }

    @Override
    public int getMaxVolume() {
        return super.getMaxVolume();
    }

    @Override
    public Memento save() { return super.save(); }

    @Override
    public void restore(Memento m) { super.restore(m); }
}
