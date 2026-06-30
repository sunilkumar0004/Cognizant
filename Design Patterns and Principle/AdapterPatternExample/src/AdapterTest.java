package adapter;

public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Adapter Pattern ===");

        PaypalGateway paypalInstance = new PaypalGateway();
        StripeGateway stripeInstance = new StripeGateway();

        PaymentProcessor paypalProcessor = new PaypalAdapter(paypalInstance);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeInstance);

        System.out.println("--- Processing Paypal Payment ---");
        paypalProcessor.processPayment("student@university.edu", 150.00);

        System.out.println("\n--- Processing Stripe Payment ---");
        stripeProcessor.processPayment("4111-2222-3333-4444", 299.99);
    }
}
