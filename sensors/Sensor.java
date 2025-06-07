package sensors;

public interface Sensor {
    String getName();
    void trigger();  // імітація події
    void addListener(SensorListener listener);
    void removeListener(SensorListener listener);
}
