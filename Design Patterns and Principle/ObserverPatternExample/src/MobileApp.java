package observer;

public class MobileApp implements Observer {
    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("Notification on Mobile App (" + appName + "): Stock " + stockName + " is now $" + price);
    }
}
