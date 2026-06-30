package strategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: Payment strategy not set!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
