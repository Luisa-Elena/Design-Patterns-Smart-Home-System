package org.example.command;

public class TurnLightOnCommand implements Command {
    private Light receiver;

    public TurnLightOnCommand(Light receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.setOn(true);
    }
}
