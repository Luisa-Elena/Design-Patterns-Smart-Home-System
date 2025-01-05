package org.example.decorator;

import org.example.bridge.Device;
import org.example.memento.Memento;

public class LoggingDecorator extends DeviceDecorator {
    public LoggingDecorator(Device wrappee) {
        super(wrappee);
    }

    @Override
    public boolean isEnabled() {
        System.out.println("[LOG] Checking if the device is enabled.");
        return super.isEnabled();
    }

    @Override
    public void enable() {
        System.out.println("[LOG] Enabling the device.");
        super.enable();
    }

    @Override
    public void disable() {
        System.out.println("[LOG] Disabling the device.");
        super.disable();
    }

    @Override
    public int getVolume() {
        System.out.println("[LOG] Getting the current volume of the device.");
        return super.getVolume();
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("[LOG] Setting the volume to " + volume);
        super.setVolume(volume);
    }

    @Override
    public int getChannel() {
        System.out.println("[LOG] Getting the current channel of the device.");
        return super.getChannel();
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("[LOG] Setting the channel to " + channel);
        super.setChannel(channel);
    }

    @Override
    public int getMaxChannel() {
        System.out.println("[LOG] Getting the maximum channel number supported on the device.");
        return super.getMaxChannel();
    }

    @Override
    public int getMaxVolume() {
        System.out.println("[LOG] Getting the maximum volume level supported on the device.");
        return super.getMaxVolume();
    }

    @Override
    public Memento save() {
        System.out.println("[LOG] Saving channel.");
        return super.save();
    }

    @Override
    public void restore(Memento m) {
        System.out.println("[LOG] Restoring channel to " + m.getChannel());
        super.restore(m);
    }
}
