package devices;

public class AirConditioner implements SmartDevice {
    private String name;

    public AirConditioner(String name) {
        this.name = name;
    }

    @Override
    public void on() {
        System.out.println(name + " air conditioner ON");
    }

    @Override
    public void off() {
        System.out.println(name + " air conditioner OFF");
    }

    @Override
    public String getName() {
        return name;
    }
}