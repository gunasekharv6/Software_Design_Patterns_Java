package design.creational.factory;

public class GoogleFactory implements StockFactory {
    @Override
    public Stock getObject() {
        return new Google();
    }
}
