class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String cat) {
        productId = id;
        productName = name;
        category = cat;
    }
}

public class ECommerceSearchFunction {
    public static int linearSearch(Product[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name)) return i;
        }
        return -1;
    }

    public static int binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Bag", "Accessories"),
            new Product(2, "Camera", "Electronics"),
            new Product(3, "Laptop", "Electronics")
        };

        // For binary search, array must be sorted by productName
        java.util.Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        System.out.println("Linear Search Index: " + linearSearch(products, "Camera"));
        System.out.println("Binary Search Index: " + binarySearch(products, "Camera"));
    }
}
