package sensors;

public interface SensorListener {
    void onSensorTriggered(String sensorName, String data);
}
