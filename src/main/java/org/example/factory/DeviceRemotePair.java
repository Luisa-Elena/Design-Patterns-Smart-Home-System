package org.example.factory;

import org.example.bridge.Device;
import org.example.bridge.Remote;

public interface DeviceRemotePair {
    public Device getDevice();
    public Remote getRemote();
}
