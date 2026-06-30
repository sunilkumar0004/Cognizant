package proxy;

public class ProxyTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Proxy Pattern ===");

        Image image1 = new ProxyImage("photo_beach.png");
        Image image2 = new ProxyImage("photo_mountains.png");

        System.out.println("Proxy objects created.");

        System.out.println("\n--- Call 1: Displaying image1 (First Time) ---");
        image1.display();

        System.out.println("\n--- Call 2: Displaying image1 (Second Time) ---");
        image1.display();

        System.out.println("\n--- Call 3: Displaying image2 (First Time) ---");
        image2.display();
    }
}
