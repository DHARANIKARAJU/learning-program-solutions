interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payAmount(double amount) {
        strategy.pay(amount);
    }
}

class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new CreditCardPayment());
        context.payAmount(250.0);
        context.setStrategy(new PayPalPayment());
        context.payAmount(300.0);
    }
}