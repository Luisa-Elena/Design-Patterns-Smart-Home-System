package org.example.state;

import org.example.observer.SecurityCamera;

public class IdleState extends CameraState{
    public IdleState(SecurityCamera camera) {
        super(camera);
        camera.setRecording(false);
        camera.setOn(true);
    }

    @Override
    public void start() {
        System.out.println("Camera starts recording...");
        camera.changeState(new RecordingState(camera));
    }

    @Override
    public void stop() {
        System.out.println("Camera is off...");
        camera.changeState(new OffState(camera));
    }
}
