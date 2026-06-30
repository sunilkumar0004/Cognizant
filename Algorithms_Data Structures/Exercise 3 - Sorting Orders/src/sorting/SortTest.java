package sorting;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Customer Orders Sorting ===");

        Order[] ordersBubble = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 99.99),
            new Order("O003", "Charlie", 450.00),
            new Order("O004", "David", 120.00),
            new Order("O005", "Eve", 75.25)
        };

        Order[] ordersQuick = Arrays.copyOf(ordersBubble, ordersBubble.length);

        System.out.println("--- Bubble Sort Test ---");
        System.out.println("Before Sorting:");
        displayOrders(ordersBubble);
        SortAlgorithms.bubbleSort(ordersBubble);
        System.out.println("After Bubble Sort:");
        displayOrders(ordersBubble);

        System.out.println("\n--- Quick Sort Test ---");
        System.out.println("Before Sorting:");
        displayOrders(ordersQuick);
        SortAlgorithms.quickSort(ordersQuick, 0, ordersQuick.length - 1);
        System.out.println("After Quick Sort:");
        displayOrders(ordersQuick);
    }

    private static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
