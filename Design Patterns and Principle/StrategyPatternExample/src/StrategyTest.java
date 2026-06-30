package strategy;

public class StrategyTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Strategy Pattern ===");

        PaymentContext context = new PaymentContext();

        System.out.println("--- Scenario 1: Paying with Credit Card ---");
        PaymentStrategy ccStrategy = new CreditCardPayment("Alice Smith", "1234-5678-9876-5432");
        context.setPaymentStrategy(ccStrategy);
        context.executePayment(250.75);

        System.out.println("\n--- Scenario 2: Paying with PayPal ---");
        PaymentStrategy ppStrategy = new PayPalPayment("alice@example.com");
        context.setPaymentStrategy(ppStrategy);
        context.executePayment(99.99);
    }
}
