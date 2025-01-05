package org.example.command;

public class ToggleLightCommand implements Command {
    private Light receiver;
    private boolean onOff;

    public ToggleLightCommand(Light receiver, boolean onOff) {
        this.receiver = receiver;
        this.onOff = onOff;
    }

    @Override
    public void execute() {
        receiver.setOn(onOff);
    }
}