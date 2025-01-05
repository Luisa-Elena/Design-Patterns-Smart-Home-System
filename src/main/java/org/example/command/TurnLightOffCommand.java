package org.example.command;

public class TurnLightOffCommand implements Command {
    private Light receiver;

    public TurnLightOffCommand(Light receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.setOn(false);
    }
}
