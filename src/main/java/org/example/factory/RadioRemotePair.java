package org.example.factory;

import org.example.bridge.Device;
import org.example.bridge.Radio;
import org.example.bridge.Remote;

public class RadioRemotePair implements DeviceRemotePair {
    private Radio radio;
    private Remote remote;

    public RadioRemotePair(Radio radio, Remote remote) {
        this.radio = radio;
        this.remote = remote;
    }

    @Override
    public Device getDevice() {
        return this.radio;
    }

    @Override
    public Remote getRemote() {
        return this.remote;
    }
}
