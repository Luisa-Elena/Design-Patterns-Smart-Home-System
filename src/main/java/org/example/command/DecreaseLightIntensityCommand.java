package org.example.command;

public class DecreaseLightIntensityCommand implements Command {
    private Light receiver;
    private int amount;

    public DecreaseLightIntensityCommand(Light receiver, int amount) {
        this.receiver = receiver;
        this.amount = amount;
    }

    @Override
    public void execute() {
        int currentIntensity = this.receiver.getIntensity();
        this.receiver.setIntensity(currentIntensity - amount);
    }
}
