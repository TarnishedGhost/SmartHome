import commands.Command;
import controller.SmartHomeController;
import devices.Light;
import devices.AirConditioner;
import devices.Alarm;
import commands.TurnOnCommand;
import commands.TurnOffCommand;
import devices.SmartDevice;
import remote.RemoteControl;
import sensors.MotionSensor;
import sensors.Sensor;
import sensors.SensorListener;
import sensors.TemperatureSensor;
import sensors.SmokeSensor;
import factory.SmartDeviceFactory;


public class Main {
    public static void main(String[] args) {
        SmartHomeController controller = SmartHomeController.getInstance();

        SmartDevice light = SmartDeviceFactory.createDevice("light", "Living Room");
        SmartDevice air = SmartDeviceFactory.createDevice("airconditioner", "Bedroom");
        SmartDevice alarm = SmartDeviceFactory.createDevice("alarm", "Security");

        controller.addDevice(light);
        controller.addDevice(air);
        controller.addDevice(alarm);

        Command turnOnLight = new TurnOnCommand(light);
        Command turnOffAC = new TurnOffCommand(air);
        Command turnOnAlarm = new TurnOnCommand(alarm);

        RemoteControl remote = new RemoteControl();
        remote.addCommand(turnOnLight);
        remote.addCommand(turnOffAC);
        remote.addCommand(turnOnAlarm);

        remote.executeAll();

        MotionSensor motionSensor = new MotionSensor("Motion Sensor");
        SmokeSensor smokeSensor = new SmokeSensor("Smoke Sensor");
        TemperatureSensor temperatureSensor = new TemperatureSensor("Temp Sensor");

        motionSensor.addListener(controller);
        smokeSensor.addListener(controller);
        temperatureSensor.addListener(controller);

         System.out.println("\n Симуляція: рух виявлено");
        motionSensor.detectMotion();

        System.out.println("\n Симуляція: дим виявлено");
        smokeSensor.detectSmoke();

        System.out.println("\n Симуляція: температура висока");
        temperatureSensor.detectHighTemperature();

        System.out.println("\n Симуляція: температура низька");
        temperatureSensor.detectLowTemperature();
    }
}
