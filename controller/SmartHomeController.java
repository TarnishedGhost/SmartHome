package controller;

import devices.SmartDevice;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeController {
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
            System.out.println("⚠️ Пристрій не знайдено: " + deviceName);
        }
    }

    public void turnOff(String deviceName) {
        SmartDevice device = findDeviceByName(deviceName);
        if (device != null) {
            device.off();
        } else {
            System.out.println("⚠️ Пристрій не знайдено: " + deviceName);
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
}
