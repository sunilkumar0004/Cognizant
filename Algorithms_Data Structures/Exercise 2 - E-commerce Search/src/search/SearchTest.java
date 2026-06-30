package search;

import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static void main(String[] args) {
        System.out.println("=== Testing E-commerce Search Function ===");

        Product[] products = {
            new Product("P005", "Desk Lamp", "Home Decor"),
            new Product("P001", "Gaming Mouse", "Electronics"),
            new Product("P003", "Mechanical Keyboard", "Electronics"),
            new Product("P002", "USB-C Cable", "Accessories"),
            new Product("P004", "Office Chair", "Furniture")
        };

        System.out.println("--- Linear Search Test ---");
        Product resultLinear = SearchAlgorithms.linearSearch(products, "P003");
        System.out.println("Found via Linear Search: " + resultLinear);

        System.out.println("\n--- Binary Search Test (Sorting Array First) ---");
        Arrays.sort(products, Comparator.comparing(Product::getProductId));
        
        System.out.println("Sorted Products:");
        for (Product p : products) {
            System.out.println(p);
        }

        Product resultBinary = SearchAlgorithms.binarySearch(products, "P003");
        System.out.println("\nFound via Binary Search: " + resultBinary);
    }
}
