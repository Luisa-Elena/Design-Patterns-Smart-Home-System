package org.example.builder;

import org.example.bridge.TV;
import org.example.command.Light;
import org.example.observer.Room;
import org.example.strategy.HeatPump;

public class RoomBuilder {
    private Room room;

    public RoomBuilder() {
        this.reset();
    }

    public void reset() {
        this.room = new Room();
    }

    public void addLight(Light light) {
        this.room.addSubscriber(light);
    }

    public void addTV(TV tv) {
        this.room.addSubscriber(tv);
    }

    public void addHeatPump(HeatPump heatPump) {
        this.room.setHeatPump(heatPump);
    }

    public Room getResult() {
        Room result = this.room;
        this.reset();
        return result;
    }
}
