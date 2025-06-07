package commands;

import devices.SmartDevice;

public class TurnOffCommand implements Command {
    private final SmartDevice device;

    public TurnOffCommand(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.off();
    }
}
