package factory;

import decorators.EnergySavingDecorator;
import decorators.LoggingDecorator;
import devices.*;
import java.util.Locale;

public class SmartDeviceFactory {
    public static SmartDevice createDevice(String type, String name) {
        SmartDevice device;

        switch (type.toLowerCase(Locale.ROOT)) {
            case "light":
                device = new Light(name);
                break;
            case "airconditioner":
                device = new AirConditioner(name);
                break;
            case "alarm":
                device = new Alarm(name);
                break;
            default:
                throw new IllegalArgumentException("Невідомий тип пристрою: " + type);
        }

        // Обгортання в декоратори (можна налаштувати гнучкіше)
        device = new LoggingDecorator(device);
        device = new EnergySavingDecorator(device);

        return device;
    }
}
