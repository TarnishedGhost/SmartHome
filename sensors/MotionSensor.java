package sensors;

import java.util.ArrayList;
import java.util.List;

public class MotionSensor implements Sensor {
    private final String name;
    private final List<SensorListener> listeners = new ArrayList<>();

    public MotionSensor(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void trigger() {
        System.out.println("📡 Детектовано рух: " + name);
        for (SensorListener listener : listeners) {
            listener.onSensorTriggered(name, "motion detected");
        }
    }

    @Override
    public void addListener(SensorListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(SensorListener listener) {
        listeners.remove(listener);
    }
}
