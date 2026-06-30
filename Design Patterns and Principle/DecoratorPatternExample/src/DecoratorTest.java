package decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Decorator Pattern ===");

        System.out.println("--- Scenario 1: Basic Email Notifier ---");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("System updated successfully.");

        System.out.println("\n--- Scenario 2: Email + SMS Notifier ---");
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("High CPU usage detected!");

        System.out.println("\n--- Scenario 3: Email + SMS + Slack Notifier ---");
        Notifier fullyDecoratedNotifier = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier()
                )
        );
        fullyDecoratedNotifier.send("Database backup completed.");
    }
}
