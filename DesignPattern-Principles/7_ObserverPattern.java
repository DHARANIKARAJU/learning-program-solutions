import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float price);
}

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private float stockPrice;

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void setStockPrice(float price) {
        this.stockPrice = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockPrice);
        }
    }
}

class MobileApp implements Observer {
    public void update(float price) {
        System.out.println("MobileApp - Stock Price Updated: " + price);
    }
}

class WebApp implements Observer {
    public void update(float price) {
        System.out.println("WebApp - Stock Price Updated: " + price);
    }
}

class ObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.register(mobile);
        market.register(web);
        market.setStockPrice(120.5f);
    }
}
