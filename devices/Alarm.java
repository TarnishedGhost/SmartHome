package devices;

public class Alarm implements SmartDevice {
    private String name;

    public Alarm(String name) {
        this.name = name;
    }

    @Override
    public void on() {
        System.out.println(name + " alarm ACTIVATED");
    }

    @Override
    public void off() {
        System.out.println(name + " alarm DEACTIVATED");
    }

    @Override
    public String getName() {
        return name;
    }
}