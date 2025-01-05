package org.example.state;

import org.example.observer.SecurityCamera;

public abstract class CameraState {
    public SecurityCamera camera;

    public CameraState(SecurityCamera camera) {
        this.camera = camera;
    }

    public abstract void start();
    public abstract void stop();
}
