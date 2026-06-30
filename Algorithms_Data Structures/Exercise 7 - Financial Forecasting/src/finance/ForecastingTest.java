package finance;

public class ForecastingTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Financial Forecasting ===");

        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // 10 years

        double futureValueRecursive = Forecasting.calculateFutureValue(presentValue, growthRate, periods);
        double futureValueIterative = Forecasting.calculateFutureValueIterative(presentValue, growthRate, periods);

        System.out.println("Present Value: $" + presentValue);
        System.out.println("Growth Rate:   " + (growthRate * 100) + "%");
        System.out.println("Period:        " + periods + " years");
        System.out.println("\nFuture Value (Recursive): $" + String.format("%.2f", futureValueRecursive));
        System.out.println("Future Value (Iterative): $" + String.format("%.2f", futureValueIterative));
    }
}
