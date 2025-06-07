package decorators;

import devices.SmartDevice;

public class LoggingDecorator extends SmartDeviceDecorator {
    public LoggingDecorator(SmartDevice device) {
        super(device);
    }

    @Override
    public void on() {
        System.out.println("[LOG] Turning ON: " + getName());
        super.on();
    }

    @Override
    public void off() {
        System.out.println("[LOG] Turning OFF: " + getName());
        super.off();
    }
}
