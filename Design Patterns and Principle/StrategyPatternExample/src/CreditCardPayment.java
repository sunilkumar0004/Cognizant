package strategy;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardName;
    private final String cardNumber;

    public CreditCardPayment(String cardName, String cardNumber) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card (" + cardName + ", card number: " + cardNumber + ")");
    }
}
