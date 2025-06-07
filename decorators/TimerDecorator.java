package decorators;

import devices.SmartDevice;

public class TimerDecorator implements SmartDevice {
    private final SmartDevice device;

    public TimerDecorator(SmartDevice device) {
        this.device = device;
    }

    @Override
    public void on() {
        System.out.println(" Таймер: увімкнення пристрою через 3 секунди...");
        try {
            Thread.sleep(3000); // імітація затримки
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        device.on();
    }

    @Override
    public void off() {
        System.out.println(" Таймер: вимкнення пристрою через 2 секунди...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        device.off();
    }

    @Override
    public String getName() {
        return device.getName();
    }
}
