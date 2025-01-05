package org.example.bridge;

import org.example.memento.Memento;

public interface Device {
    public boolean isEnabled();
    public void enable();
    public void disable();
    public int getVolume();
    public void setVolume(int volume);
    public int getChannel();
    public void setChannel(int channel);
    public int getMaxChannel();
    public int getMaxVolume();
    public Memento save();
    public void restore(Memento m);
}
