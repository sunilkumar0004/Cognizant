package adapter;

public class PaypalGateway {
    public void makePayment(String email, double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal for user: " + email);
    }
}
