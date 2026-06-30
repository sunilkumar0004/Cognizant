package singleton;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Pattern ===");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        if (logger1 == logger2) {
            System.out.println("Success: Both logger1 and logger2 point to the same instance.");
        } else {
            System.out.println("Failure: Different instances detected!");
        }
    }
}
