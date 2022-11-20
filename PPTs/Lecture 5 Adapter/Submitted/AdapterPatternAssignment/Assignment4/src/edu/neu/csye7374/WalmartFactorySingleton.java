package edu.neu.csye7374;

public class WalmartFactorySingleton extends AbstractFactory{

    private static WalmartFactorySingleton instance=null;   //Implementing Lazy singleton method

    private WalmartFactorySingleton() {
    }

    public static WalmartFactorySingleton getInstance() {
        if(instance==null)
        {
            synchronized(WalmartFactorySingleton.class) {
                if(instance==null) {
                    instance = new WalmartFactorySingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public StockAPI getObject() {
        return new Walmart();
    }
}
