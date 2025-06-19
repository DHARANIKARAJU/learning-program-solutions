class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int id, String name, double price) {
        orderId = id;
        customerName = name;
        totalPrice = price;
    }

    public String toString() {
        return orderId + " - " + customerName + ": $" + totalPrice;
    }
}

public class SortingCustomerOrders {

    public static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice < pivot) {
                i++;
                Order temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        Order temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 250.0),
            new Order(102, "Bob", 100.0),
            new Order(103, "Charlie", 400.0)
        };

        System.out.println("Before sorting:");
        for (Order o : orders) System.out.println(o);

        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nAfter Quick Sort:");
        for (Order o : orders) System.out.println(o);
    }
}
