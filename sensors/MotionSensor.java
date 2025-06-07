package sensors;
import sensors.SensorListener;
import sensors.TemperatureSensor;
import sensors.SmokeSensor;


import java.util.ArrayList;
import java.util.List;

public class MotionSensor implements Sensor {
    private final String name;
    private final List<SensorListener> listeners = new ArrayList<>();

    public MotionSensor(String name) {
        this.name = name;
    }

    public void detectMotion() {
        System.out.println("📡 Motion detected by " + name);
        for (SensorListener listener : listeners) {
            listener.onSensorTriggered(name, "motion detected");
        }
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
