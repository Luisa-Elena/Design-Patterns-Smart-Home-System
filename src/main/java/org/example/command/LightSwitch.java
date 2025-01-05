package org.example.command;

import java.util.ArrayList;

public class LightSwitch {
    private ArrayList<SwitchButton> buttons;

    public LightSwitch() {
        this.buttons = new ArrayList<>();
    }

    public void addButton(SwitchButton button) {
        this.buttons.add(button);
    }

    public ArrayList<SwitchButton> getButtons() {
        return buttons;
    }
}
