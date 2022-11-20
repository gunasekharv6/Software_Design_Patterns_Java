package edu.neu.csye7374;

public class Costco extends StockAPI {

    public Costco() {
    }

    public Costco(String name, double price, String description, double ask) {
        super(name, price, description, ask);
    }

    @Override
    public int getMetric() {
    	int metric = getStrategy().getPerformanceMetric();
    	setMteric(metric);
    	return metric;
    }
    	
//        double bidAvg = getBidTotal()/getBids().size();
////        if(bidAvg>getAsk()) {
////            return 1;
////        }else if(bidAvg<getAsk()) {
////            return -1;
////        }
////        return 0;
//        double spread = bidAvg-getAsk();
//
//        if(spread>0.02*bidAvg) {
//            setMteric(1);
//            return 1;
//        }else if(spread<0.01*bidAvg) {
//            setMteric(-1);
//            return -1;
//        }else{
//            setMteric(0);
//            return 0;
//        }
}
