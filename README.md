# Design Patterns - Smart Home System

## **Overview**  
Java console application focusing on using multiple design patterns.  


## **Design patterns used:**
## *Bridge*  
- Between devices and their remotes.
- The Remote class is the abstraction part and the classes TV and Radio implementing the Device interface are the implementation part of this pattern.
- The remote being the abstraction object delegates the work to the acual devices.
- The remotes work with the devices via the same Device interface so the same remote can support multiple devices.


## *Factory*  
- The DeviceFactory abstract class has the method createDevice().
- Since whenever we create a device, we need its corresponding remote, the method returns an object of type DeviceRemotePair.
- The classes RadioRemotePair and TVRemotePair implement the DeviceRemotePair interface, each having a device (radio or TV) and remote fields.
- The concrete factory classes are RadioFactory and TVFactory. They implement the createDevice() method from their parent class (DeviceFactory) and return the corresponding concrete pair.
- This way, the creation of remotes linked to a specific device is delegated to specialized classes.

## *Decorator*
- Used to add additional features to the devices.
- The DeviceDecorator class implements the Device interface.
- The concrete decorators, meaning the LoggingDecorator and the VolumeLimiterDecorator classes extend the DeviceDecorator class which has a 'wrappee' field of type Device.
- The LoggingDecorator prints an informative message for each method called in its wrappee device.
- The VolumeLimiterDecorator limits the volume to a maximum volume given as parameter to its constructor. The volume in its wrappee device cannot be increased above the limit.
- After a device is replaced with a decorator, the corresponding remote must set its device to the decorator.

## *Memento*
- This design pattern is used to be able to undo any channel change for a device.
- The Remote holds a stack of Memento objects which store the channels.
- The devices can save and restore the channels with the help of Memento objects.

## *Command*
- This design pattern is used to implement the lights and switches system.
- A LightSwitch object has multiple buttons. Each button executes a command targetting a certain light.
- The possible commands are: turn a light on, turn a light off, increase the intensity of a light by a certain amount or decrease the intensity by a certain amount.

## *Observer*
- The Observer design pattern is used to notify all subscribers of a Room object if the room is empty or not.
- The TV class and the Light class also implement the Subscriber interface.
- If the room is empty the TV's brightness is set to low and the lights are off.
- If someone enters the room and the room is not empty, the TV's brightness is set to high and the lights are on.
- This pattern is also used for implementing a security system. A motion sensor is the publisher and the subscribers are a security camera, an outdoor light and the door lock. The motion sensor notifies its subscribers if there is an alert state or not. In case of an alert (motion detected) the light turns on, the door is locked and if the security camera is on, it starts recording. Else, the light turns off, the door is unlocked and if the camera is on it goes in idle state, waiting either to be stopped or to start recording.

## *State*
- This design pattern is used to implement the security camera.
- The security camera can have three states: Idle, Recording and Off.
- From Idle, the start() method gets the camera in the Recording state, and the stop() method gets the camera in Off state.
- From Recording state, the stop() method gets the camera in Idle.
- From Off, the start() method gets the camera in Idle.

## *Strategy*
- This pattern is used to implement the HeatPump class.
- A heat pump cam either cool down a room or heat it up.
- Based on the current temperature and the desired temperature, the heat pump chooses the correct strategy to reach the desired temperature.
- The heating strategy increases the temperature by one, while the cooling strategy decreases the temperature by one.


## *Builder*
- Builder is used to create multiple types of rooms and avoiding a telescopic constructor.
- A room can have only a TV, light or heat pump, or just 2 elements from these 3 or all of them.
- The RoomBuilder class is responsible to declare methods for adding an element to a room.
- The Director class holds a RoomBuilder instance and uses it to create a room of the specified type.
- All possible types for a room are in the RoomType enum.
