package edu.neu.csye7374;

public class WalmartFactory extends AbstractFactory{

    public WalmartFactory() {
    }

//    public static WalmartFactory getInstance() {
//        if(instance==null)
//        {
//            synchronized(WalmartFactorySingleton.class) {
//                if(instance==null) {
//                    instance = new WalmartFactory();
//                }
//            }
//        }
//        return instance;
//    }


    @Override
    public StockAPI getObject() {
        return new Walmart();
    }
}
