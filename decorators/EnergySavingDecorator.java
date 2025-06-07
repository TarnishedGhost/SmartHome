package decorators;

import devices.SmartDevice;

public class EnergySavingDecorator extends SmartDeviceDecorator {

    public EnergySavingDecorator(SmartDevice device) {
        super(device);
    }

    @Override
    public void on() {
        if (isLowPriorityDevice()) {
            System.out.println("[ENERGY-SAVING] " + getName() + " не буде увімкнено зараз (низький пріоритет).");
            // Симуляція економії енергії — не вмикаємо пристрій.
        } else {
            System.out.println("[ENERGY-SAVING] Увімкнення пристрою з оптимізацією: " + getName());
            decoratedDevice.on();
        }
    }

    @Override
    public void off() {
        System.out.println("[ENERGY-SAVING] Вимкнення пристрою: " + getName());
        decoratedDevice.off();
    }

    private boolean isLowPriorityDevice() {
        return getName().toLowerCase().contains("light")
            || getName().toLowerCase().contains("tv")
            || getName().toLowerCase().contains("fan");
    }
}
