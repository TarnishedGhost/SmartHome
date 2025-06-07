import commands.Command;
import controller.SmartHomeController;
import devices.Light;
import devices.AirConditioner;
import devices.Alarm;
import commands.TurnOnCommand;
import commands.TurnOffCommand;
import devices.SmartDevice;
import remote.RemoteControl;



public class Main {
    public static void main(String[] args) {
        SmartHomeController controller = SmartHomeController.getInstance();

        SmartDevice light = new Light("Living Room");
        SmartDevice air = new AirConditioner("Bedroom");
        SmartDevice alarm = new Alarm("Security");

        controller.addDevice(new Light("Living Room"));
        controller.addDevice(new AirConditioner("Bedroom"));
        controller.addDevice(new Alarm("Security"));

        Command turnOnLight = new TurnOnCommand(light);
        Command turnOffAC = new TurnOffCommand(air);
        Command turnOnAlarm = new TurnOnCommand(alarm);

        RemoteControl remote = new RemoteControl();
        remote.addCommand(turnOnLight);
        remote.addCommand(turnOffAC);
        remote.addCommand(turnOnAlarm);

        remote.executeAll();
    }
}
