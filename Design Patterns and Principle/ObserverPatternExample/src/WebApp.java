package observer;

public class WebApp implements Observer {
    private final String url;

    public WebApp(String url) {
        this.url = url;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("Notification on Web Portal (" + url + "): " + stockName + " price changed to $" + price);
    }
}
