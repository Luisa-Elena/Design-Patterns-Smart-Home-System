package org.example.strategy;

public class HeatingStrategy implements Strategy {
    @Override
    public int executeStrategy(int temperature) {
        return temperature - 1;
    }
}
