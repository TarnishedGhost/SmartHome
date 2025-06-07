package controller;

import devices.SmartDevice;
import sensors.SensorListener;


import java.util.ArrayList;
import java.util.List;

public class SmartHomeController implements SensorListener {
    private static SmartHomeController instance;
    private final List<SmartDevice> devices;

    private SmartHomeController() {
        devices = new ArrayList<>();
    }

    public static synchronized SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    public void addDevice(SmartDevice device) {
        if (device != null) {
            devices.add(device);
            System.out.println("✅ Пристрій додано: " + device.getName());
        }
    }

    public void turnOnAll() {
        System.out.println("\n🔌 Увімкнення всіх пристроїв:");
        for (SmartDevice device : devices) {
            device.on();
        }
    }

    public void turnOffAll() {
        System.out.println("\n🔌 Вимкнення всіх пристроїв:");
        for (SmartDevice device : devices) {
            device.off();
        }
    }

    public void turnOn(String deviceName) {
        SmartDevice device = findDeviceByName(deviceName);
        if (device != null) {
            device.on();
        } else {
            System.out.println(" Пристрій не знайдено: " + deviceName);
        }
    }

    public void turnOff(String deviceName) {
        SmartDevice device = findDeviceByName(deviceName);
        if (device != null) {
            device.off();
        } else {
            System.out.println(" Пристрій не знайдено: " + deviceName);
        }
    }

    public List<SmartDevice> getDevices() {
        return devices;
    }

    private SmartDevice findDeviceByName(String name) {
        for (SmartDevice device : devices) {
            if (device.getName().equalsIgnoreCase(name)) {
                return device;
            }
        }
        return null;
    }

    @Override
    public void onSensorTriggered(String sensorName, String data) {
        System.out.println("📥 Сигнал від сенсора [" + sensorName + "]: " + data);
        String event = data.toLowerCase();

        if (event.equals("motion detected")) {
            SmartDevice light = findDeviceByName("Living Room");
            if (light != null) light.on();
        } 
        else if (event.equals("smoke detected")) {
            SmartDevice alarm = findDeviceByName("Security");
            if (alarm != null) alarm.on();
        } 
        else if (event.equals("temperature high")) {
            SmartDevice air = findDeviceByName("Bedroom");
            if (air != null) air.on();
        } 
        else if (event.equals("temperature low")) {
            SmartDevice air = findDeviceByName("Bedroom");
            if (air != null) air.off();
        } 
        else {
            System.out.println("Невідома подія: " + data);
        }
    }
}
    
