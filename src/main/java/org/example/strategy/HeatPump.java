package org.example.strategy;

public class HeatPump {
    private Strategy strategy;
    private int temperature;

    public HeatPump(int temperature) {
        this.strategy = null;
        this.temperature = temperature;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void changeTemperature(int desiredTemperature) {
        System.out.println("Currently having " + this.temperature + " degrees.");
        System.out.println("Changing the temperature to " + desiredTemperature + " degrees.");

        if(desiredTemperature == this.temperature) {
            System.out.println("Already having this temperature.");
            return;
        }
        if(desiredTemperature < this.temperature) {
            setStrategy(new CoolingStrategy());
        }
        if (desiredTemperature > this.temperature) {
            setStrategy((new HeatingStrategy()));
        }

        setTemperature(strategy.executeStrategy(this.temperature));
        while(this.temperature != desiredTemperature) {
            setTemperature(strategy.executeStrategy(this.temperature));
        }

        System.out.println("Temperature reached " + this.temperature + " degrees.");
    }
}
