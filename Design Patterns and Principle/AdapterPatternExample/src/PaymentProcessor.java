package adapter;

public interface PaymentProcessor {
    void processPayment(String account, double amount);
}
