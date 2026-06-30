package command;

public class Light {
    private final String room;

    public Light(String room) {
        this.room = room;
    }

    public void turnOn() {
        System.out.println(room + " Light is turned ON.");
    }

    public void turnOff() {
        System.out.println(room + " Light is turned OFF.");
    }
}
