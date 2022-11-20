package edu.neu.csye7374;

public class CostcoFactorySingleton extends AbstractFactory{
    private static CostcoFactorySingleton instance=new CostcoFactorySingleton();  // Implementing Eager Singleton

    private CostcoFactorySingleton() {
    }

    public static CostcoFactorySingleton getInstance() {
        return instance;
    }

    @Override
    public StockAPI getObject() {
        return new Costco();
    }
}
