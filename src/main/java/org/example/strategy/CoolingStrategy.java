package org.example.strategy;

public class CoolingStrategy implements Strategy {
    @Override
    public int executeStrategy(int temperature) {
        return temperature + 1;
    }
}