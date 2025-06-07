package devices;

public class Light implements SmartDevice {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " light ON");
    }

    public void off() {
        System.out.println(name + " light OFF");
    }

    public String getName() {
        return name;
    }
}
