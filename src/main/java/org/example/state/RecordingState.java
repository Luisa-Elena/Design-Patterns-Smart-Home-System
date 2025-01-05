package org.example.state;

import org.example.observer.SecurityCamera;

public class RecordingState extends CameraState {
    public RecordingState(SecurityCamera camera) {
        super(camera);
        camera.setRecording(true);
    }

    @Override
    public void start() {
        System.out.println("Already recording...");
    }

    @Override
    public void stop() {
        System.out.println("Camera goes to idle...");
        camera.changeState(new IdleState(camera));
    }
}
