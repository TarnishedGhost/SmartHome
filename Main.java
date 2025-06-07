import controller.SmartHomeController;
import devices.Light;
import devices.AirConditioner;
import devices.Alarm;

public class Main {
    public static void main(String[] args) {
        SmartHomeController controller = SmartHomeController.getInstance();

        controller.addDevice(new Light("Living Room"));
        controller.addDevice(new AirConditioner("Bedroom"));
        controller.addDevice(new Alarm("Security"));

        controller.turnOnAll();      
        controller.turnOff("Bedroom");
        controller.turnOn("Security"); 
        controller.turnOffAll(); 
    }
}
