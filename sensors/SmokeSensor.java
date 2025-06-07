package sensors;

import java.util.ArrayList;
import java.util.List;

public class SmokeSensor {
    private final String name;
    private final List<SensorListener> listeners = new ArrayList<>();

    public SmokeSensor(String name) {
        this.name = name;
    }

    public void addListener(SensorListener listener) {
        listeners.add(listener);
    }

    public void detectSmoke() {
        System.out.println("📡 Smoke detected by " + name);
        for (SensorListener listener : listeners) {
            listener.onSensorTriggered(name, "smoke detected");
        }
    }
}
