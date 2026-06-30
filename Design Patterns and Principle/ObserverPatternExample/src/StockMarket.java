package observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private final String stockName;
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.price = initialPrice;
    }

    public void setPrice(double newPrice) {
        System.out.println("\nStock update: " + stockName + " price changed to $" + newPrice);
        this.price = newPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}
