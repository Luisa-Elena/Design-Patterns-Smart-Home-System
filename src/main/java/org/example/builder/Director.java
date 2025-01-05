package org.example.builder;

import org.example.bridge.TV;
import org.example.command.Light;
import org.example.factory.TVFactory;
import org.example.observer.Room;
import org.example.strategy.HeatPump;

public class Director {
    private RoomBuilder roomBuilder;

    public Director() {
        this.roomBuilder = new RoomBuilder();
    }

    public Room createRoom(RoomType roomType){
        roomBuilder.reset();

        TVFactory tvFactory = new TVFactory();
        switch (roomType) {
            case ONLY_TV:
                roomBuilder.addTV((TV) tvFactory.createDevice().getDevice());
                break;
            case ONLY_LIGHT:
                roomBuilder.addLight(new Light());
                break;
            case ONLY_HEAT_PUMP:
                roomBuilder.addHeatPump(new HeatPump(20)); //let 20 be the default temmperature value in a room
                break;
            case LIGHT_AND_TV:
                roomBuilder.addLight(new Light());
                roomBuilder.addTV((TV) tvFactory.createDevice().getDevice());
                break;
            case LIGHT_AND_HEAT_PUMP:
                roomBuilder.addLight(new Light());
                roomBuilder.addHeatPump(new HeatPump(20));
                break;
            case TV_AND_HEAT_PUMP:
                roomBuilder.addTV((TV) tvFactory.createDevice().getDevice());
                roomBuilder.addHeatPump(new HeatPump(20));
                break;
            case LIGHT_TV_HEATPUMP:
                roomBuilder.addLight(new Light());
                roomBuilder.addTV((TV) tvFactory.createDevice().getDevice());
                roomBuilder.addHeatPump(new HeatPump(20));
                break;
        }

        return roomBuilder.getResult();
    }
}
