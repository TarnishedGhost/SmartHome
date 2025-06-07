package decorators;

import devices.SmartDevice;

public abstract class SmartDeviceDecorator implements SmartDevice {
    protected final SmartDevice decoratedDevice;

    public SmartDeviceDecorator(SmartDevice device) {
        this.decoratedDevice = device;
    }

    @Override
    public void on() {
        decoratedDevice.on();
    }

    @Override
    public void off() {
        decoratedDevice.off();
    }

    @Override
    public String getName() {
        return decoratedDevice.getName();
    }
}
