package observer;

public class ObserverTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Observer Pattern ===");

        StockMarket googleStock = new StockMarket("GOOGL", 180.50);

        Observer mobileApp = new MobileApp("TradeAlert");
        Observer webPortal = new WebApp("https://investorportal.com");

        System.out.println("Registering TradeAlert Mobile App and InvestorPortal Web App...");
        googleStock.registerObserver(mobileApp);
        googleStock.registerObserver(webPortal);

        googleStock.setPrice(182.25);
        googleStock.setPrice(185.00);

        System.out.println("\nDeregistering InvestorPortal Web App...");
        googleStock.deregisterObserver(webPortal);

        googleStock.setPrice(184.50);
    }
}
