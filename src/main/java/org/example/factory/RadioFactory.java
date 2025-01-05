package org.example.factory;

import org.example.bridge.Radio;
import org.example.bridge.Remote;

public class RadioFactory extends DeviceFactory {
    @Override
    public DeviceRemotePair createDevice() {
        Radio radio = new Radio();
        Remote remote = new Remote(radio);
        return new RadioRemotePair(radio, remote);
    }
}
