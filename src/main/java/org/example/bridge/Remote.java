package org.example.bridge;

import org.example.memento.Memento;

import java.util.Stack;

public class Remote {
    private Device device;
    private Stack<Memento> channelsHistory = new Stack<Memento>();

    public Remote(Device device) {
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void togglePower() {
        if(this.device.isEnabled()) {
            this.device.disable();
        } else {
            this.device.enable();
        }
    }

    public void volumeUp() {
        if(this.device.isEnabled()) {
            int currentVolume = this.device.getVolume();
            if (currentVolume + 1 <= device.getMaxVolume()) {
                this.device.setVolume(currentVolume + 1);
            }
        } else {
            System.out.println("Enable the device before setting the volume up.");
        }
    }

    public void volumeDown() {
        if(this.device.isEnabled()) {
            int currentVolume = this.device.getVolume();
            if (currentVolume - 1 >= 0) {
                this.device.setVolume(currentVolume - 1);
            }
        } else {
            System.out.println("Enable the device before setting the volume down.");
        }
    }

    public void channelUp() {
        if(this.device.isEnabled()) {
            int currentChannel = this.device.getChannel();
            Memento m = this.device.save();
            this.channelsHistory.push(m);
            if (currentChannel + 1 <= this.device.getMaxChannel()) {
                this.device.setChannel(currentChannel + 1);
            } else {
                this.device.setChannel(0);
            }
        } else {
            System.out.println("Enable the device before setting the channel up.");
        }
    }

    public void channelDown() {
        if (this.device.isEnabled()) {
            int currentChannel = this.device.getChannel();
            Memento m = this.device.save();
            this.channelsHistory.push(m);
            if (currentChannel - 1 >= 0) {
                this.device.setChannel(currentChannel - 1);
            } else {
                this.device.setChannel(this.device.getMaxChannel());
            }
        } else {
            System.out.println("Enable the device before setting the channel down.");
        }
    }

    public void goToChannel(int newChannel) {
        if(this.device.isEnabled()) {
            if(newChannel <= this.device.getMaxChannel()) {
                Memento m = this.device.save();
                this.channelsHistory.push(m);
                this.device.setChannel(newChannel);
            } else {
                System.out.println("This channel does not exist.");
            }
        } else {
            System.out.println("Enable the device before changing the channel.");
        }
    }

    public void goBack() {
        if(this.device.isEnabled()) {
            if(!this.channelsHistory.empty()) {
                Memento m = this.channelsHistory.pop();
                this.device.restore(m);
            } else {
                System.out.println("Channels history is empty.");
            }
        } else {
            System.out.println("Enable the device before going back the channel.");
        }
    }
}
