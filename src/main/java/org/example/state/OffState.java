package org.example.state;

import org.example.observer.SecurityCamera;

public class OffState extends CameraState {
    public OffState(SecurityCamera camera) {
        super(camera);
        camera.setOn(false);
        camera.setRecording(false);
    }

    @Override
    public void start() {
        System.out.println("Camera goes to idle...");
        camera.changeState(new IdleState(camera));
    }

    @Override
    public void stop() {
        System.out.println("Already off...");
    }
}
