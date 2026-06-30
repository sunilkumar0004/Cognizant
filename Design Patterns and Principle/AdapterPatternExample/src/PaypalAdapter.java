package adapter;

public class PaypalAdapter implements PaymentProcessor {
    private final PaypalGateway paypalGateway;

    public PaypalAdapter(PaypalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    @Override
    public void processPayment(String account, double amount) {

        paypalGateway.makePayment(account, amount);
    }
}
