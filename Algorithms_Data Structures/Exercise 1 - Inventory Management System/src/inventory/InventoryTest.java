package inventory;

public class InventoryTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Inventory Management System ===");
        
        Inventory inventory = new Inventory();

        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Smartphone", 25, 499.99);
        Product p3 = new Product("P003", "Wireless Headphones", 50, 79.99);

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        System.out.println("\nUpdating Smartphone quantity to 30 and price to $479.99...");
        inventory.updateProduct("P002", 30, 479.99);
        inventory.displayInventory();

        System.out.println("\nDeleting Wireless Headphones (P003)...");
        inventory.deleteProduct("P003");
        inventory.displayInventory();
    }
}
