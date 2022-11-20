package edu.neu.csye7374;

public class CostcoFactory extends AbstractFactory{

    public CostcoFactory() {
    }

    @Override
    public StockAPI getObject() {

        return new Costco();
    }
}
