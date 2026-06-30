package command;

public class CommandTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Command Pattern ===");

        Light livingRoomLight = new Light("Living Room");

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        System.out.println("--- Scenario 1: Turning Light ON ---");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("\n--- Scenario 2: Turning Light OFF ---");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
