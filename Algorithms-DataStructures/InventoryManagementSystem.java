import java.util.HashMap;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName +
               ", Quantity: " + quantity + ", Price: $" + price;
    }
}

public class InventoryManagementSystem {
    static HashMap<Integer, Product> inventory = new HashMap<>();

    public static void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    public static void updateProduct(int id, int newQuantity, double newPrice) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = newQuantity;
            p.price = newPrice;
        }
    }

    public static void deleteProduct(int id) {
        inventory.remove(id);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addProduct(new Product(1, "Mouse", 10, 25.5));
        addProduct(new Product(2, "Keyboard", 5, 45.0));

        System.out.println("Inventory:");
        inventory.values().forEach(System.out::println);

        updateProduct(2, 8, 42.0);
        System.out.println("\nAfter update:");
        inventory.values().forEach(System.out::println);

        deleteProduct(1);
        System.out.println("\nAfter delete:");
        inventory.values().forEach(System.out::println);
    }
}
