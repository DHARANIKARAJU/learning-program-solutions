interface PaymentProcessor {
    void processPayment(double amount);
}

class OldPaymentGateway {
    void makePayment(double amount) {
        System.out.println("Payment of " + amount + " made using Old Gateway");
    }
}

class PaymentAdapter implements PaymentProcessor {
    OldPaymentGateway gateway = new OldPaymentGateway();

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}

class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentAdapter();
        processor.processPayment(500.0);
    }
}
