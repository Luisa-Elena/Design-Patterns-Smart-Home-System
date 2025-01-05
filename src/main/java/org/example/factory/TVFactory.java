package org.example.factory;

import org.example.bridge.Remote;
import org.example.bridge.TV;

public class TVFactory extends DeviceFactory {
    @Override
    public DeviceRemotePair createDevice() {
        TV tv = new TV();
        Remote remote = new Remote(tv);
        return new TVRemotePair(tv, remote);
    }
}
