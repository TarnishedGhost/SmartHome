package commands;

import devices.SmartDevice;

public class TurnOnCommand implements Command {
    private final SmartDevice device;

    public TurnOnCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.on();
    }
}
