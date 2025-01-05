package org.example;

import org.example.builder.Director;
import org.example.builder.RoomType;
import org.example.command.*;
import org.example.decorator.LoggingDecorator;
import org.example.factory.DeviceRemotePair;
import org.example.factory.RadioFactory;
import org.example.factory.TVFactory;
import org.example.observer.*;
import org.example.strategy.HeatPump;

public class Main {

    public static void main(String[] args) {

        TVFactory tvFactory = new TVFactory();
        RadioFactory radioFactory = new RadioFactory();

        DeviceRemotePair myTV = tvFactory.createDevice();
        DeviceRemotePair myRadio = radioFactory.createDevice();

        System.out.println("TV:");
        myTV.getRemote().channelUp();
        myTV.getRemote().togglePower();
        myTV.getRemote().channelUp();
        System.out.println("TV channel " + myTV.getDevice().getChannel());

        System.out.println("\nRadio:");
        myRadio.getRemote().volumeUp();
        myRadio.getRemote().togglePower();
        myRadio.getRemote().volumeUp();
        System.out.println("Radio volume " + myRadio.getDevice().getVolume());

        System.out.println("\nDecorators:");
        LoggingDecorator loggingDecorator = new LoggingDecorator(myTV.getDevice());
        myTV.getRemote().setDevice(loggingDecorator);

        myTV.getRemote().goToChannel(5);
        myTV.getRemote().channelUp();
        myTV.getRemote().goBack();
        myTV.getRemote().goBack();

        System.out.println("\nCommand:");
        Light light = new Light();
        TurnLightOnCommand turnLightOnCommand = new TurnLightOnCommand(light);
        TurnLightOffCommand turnLightOffCommand = new TurnLightOffCommand(light);
        IncreaseLightIntensityCommand increaseLightIntensityCommand = new IncreaseLightIntensityCommand(light, 5);
        DecreaseLightIntensityCommand decreaseLightIntensityCommand = new DecreaseLightIntensityCommand(light, 5);
        LightSwitch lightSwitch = new LightSwitch();
        lightSwitch.addButton(new SwitchButton(turnLightOffCommand));
        lightSwitch.addButton(new SwitchButton(turnLightOnCommand));
        lightSwitch.addButton(new SwitchButton(increaseLightIntensityCommand));
        lightSwitch.addButton(new SwitchButton(decreaseLightIntensityCommand));
        lightSwitch.getButtons().get(0).executeCommand();
        lightSwitch.getButtons().get(1).executeCommand();
        lightSwitch.getButtons().get(2).executeCommand();
        lightSwitch.getButtons().get(3).executeCommand();

        System.out.println("\nObserver:");
        DoorLock doorLock = new DoorLock(true);
        OutdoorLight outdoorLight = new OutdoorLight(false);
        SecurityCamera securityCamera = new SecurityCamera(true);
        MotionSensor motionSensor = new MotionSensor(false);
        motionSensor.addSubscriber(doorLock);
        motionSensor.addSubscriber(outdoorLight);
        motionSensor.addSubscriber(securityCamera);
        securityCamera.getCameraState();
        motionSensor.setAlertState(true);
        motionSensor.setAlertState(false);
        securityCamera.stop();
        motionSensor.setAlertState(true);
        securityCamera.start();
        motionSensor.setAlertState(true);

        Room room = new Room();
        room.addSubscriber(light);
        room.addSubscriber((Subscriber) myTV.getDevice());
        System.out.println("\nRoom is empty");
        room.setEmpty(true);
        room.setEmpty(true);
        System.out.println("\nRoom is not empty");
        room.setEmpty(false);

        System.out.println("\nStrategy:");
        HeatPump heatPump = new HeatPump(23);
        heatPump.changeTemperature(20);
        heatPump.changeTemperature(20);
        heatPump.changeTemperature(24);

        System.out.println("\nBuilder:");
        Director director = new Director();
        Room roomWithTV = director.createRoom(RoomType.ONLY_TV);
        System.out.println("--- Room with only TV is empty:");
        roomWithTV.setEmpty(true);
        Room roomWithLightsAndTV = director.createRoom(RoomType.LIGHT_AND_TV);
        System.out.println("--- Room with lights and TV is empty:");
        roomWithLightsAndTV.setEmpty(true);
        Room roomWithLightsTVAndHeatPump = director.createRoom(RoomType.LIGHT_TV_HEATPUMP);
        System.out.println("--- Changing temperature for room with heat pump");
        roomWithLightsTVAndHeatPump.getHeatPump().changeTemperature(24);
        System.out.println("--- Room with all is empty:");
        roomWithLightsTVAndHeatPump.setEmpty(true);
        System.out.println("--- Room with all is not empty:");
        roomWithLightsTVAndHeatPump.setEmpty(false);
    }
}