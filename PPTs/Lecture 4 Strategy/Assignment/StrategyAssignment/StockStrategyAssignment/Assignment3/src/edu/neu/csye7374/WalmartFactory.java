package edu.neu.csye7374;

public class WalmartFactory extends AbstractFactory{

    public WalmartFactory() {
    }

    @Override
    public StockAPI getObject() {
        return new Walmart();
    }
}
