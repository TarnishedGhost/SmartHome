package sensors;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor {
    private final String name;
    private final List<SensorListener> listeners = new ArrayList<>();

    public TemperatureSensor(String name) {
        this.name = name;
    }

    public void addListener(SensorListener listener) {
        listeners.add(listener);
    }

    public void detectHighTemperature() {
        System.out.println("🌡️ High temperature detected by " + name);
        for (SensorListener listener : listeners) {
            listener.onSensorTriggered(name, "temperature high");
        }
    }

    public void detectLowTemperature() {
        System.out.println("🌡️ Low temperature detected by " + name);
        for (SensorListener listener : listeners) {
            listener.onSensorTriggered(name, "temperature low");
        }
    }
}
