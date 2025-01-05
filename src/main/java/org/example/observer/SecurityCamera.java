package org.example.observer;

import org.example.state.CameraState;
import org.example.state.IdleState;
import org.example.state.RecordingState;

public class SecurityCamera implements Subscriber {
    private boolean recording;
    private CameraState cameraState;

    private boolean on;

    public SecurityCamera(boolean on) {
        this.on = on;
        this.recording = false;
        this.cameraState = new IdleState(this);
    }

    @Override
    public void update(boolean alertState) {
        if(this.on) {
            this.recording = alertState;
            if (alertState) {
                this.cameraState.start();
            } else {
                this.cameraState.stop();
            }
            System.out.println("[CAMERA UPDATED] Camera state=" + this.cameraState + "   isRecording=" + this.recording + "   isON=" + this.on);
        } else {
            System.out.println("[CAMERA OFF] Camera state=" + this.cameraState + "   isRecording=" + this.recording + "   isON=" + this.on);
        }
    }

    public void start() {
        this.cameraState.start();
    }

    public void stop() {
        this.cameraState.stop();
    }

    public void changeState(CameraState state) {
        this.cameraState = state;
    }

    public boolean isRecording() {
        return recording;
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }

    public CameraState getCameraState() {
        System.out.println("[CAMERA GETTER] Camera state=" + this.cameraState + "   isRecording=" + this.recording + "   isON=" + this.on);
        return cameraState;
    }

    public void setCameraState(CameraState cameraState) {
        this.cameraState = cameraState;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}
