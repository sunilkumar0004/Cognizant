package adapter;

public class StripeGateway {
    public void chargeCard(String cardNumber, double amount, String currency) {
        System.out.println("Charging card: " + cardNumber + " for amount: " + amount + " " + currency + " via Stripe");
    }
}
