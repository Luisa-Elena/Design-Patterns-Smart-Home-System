package org.example.factory;

import org.example.bridge.Device;
import org.example.bridge.Remote;
import org.example.bridge.TV;

public class TVRemotePair implements DeviceRemotePair {
    private TV tv;
    private Remote remote;

    public TVRemotePair(TV tv, Remote remote) {
        this.tv = tv;
        this.remote = remote;
    }

    @Override
    public Device getDevice() {
        return this.tv;
    }

    @Override
    public Remote getRemote() {
        return this.remote;
    }
}
