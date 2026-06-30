package library;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Library Management System ===");

        Book[] books = {
            new Book("B001", "Design Patterns", "Gang of Four"),
            new Book("B002", "Clean Code", "Robert C. Martin"),
            new Book("B003", "The Pragmatic Programmer", "Andy Hunt"),
            new Book("B004", "Introduction to Algorithms", "Thomas H. Cormen")
        };

        System.out.println("--- Linear Search Test ---");
        Book foundLinear = Library.linearSearchByTitle(books, "Clean Code");
        System.out.println("Found (Linear): " + foundLinear);

        System.out.println("\n--- Binary Search Test (Sorting Books by Title First) ---");
        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
        
        System.out.println("Sorted Library Catalog:");
        for (Book b : books) {
            System.out.println(b);
        }

        Book foundBinary = Library.binarySearchByTitle(books, "Clean Code");
        System.out.println("\nFound (Binary): " + foundBinary);
    }
}
