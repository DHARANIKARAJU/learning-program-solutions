
interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    public void send() {
        System.out.println("Sending Email Notification");
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send() {
        notifier.send();
    }
}

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) { super(notifier); }

    public void send() {
        super.send();
        System.out.println("Sending SMS Notification");
    }
}

class DecoratorTest {
    public static void main(String[] args) {
        Notifier notifier = new SMSNotifier(new EmailNotifier());
        notifier.send();
    }
}
