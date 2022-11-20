package edu.neu.csye7374;

public class Walmart extends StockAPI{

	public Walmart() {
		super();
	}

	public Walmart(String name, double price, String description, double ask) {
		super(name, price, description, ask);
	}

	public int getMetric() {
		int metric = getStrategy().getPerformanceMetric();
    	setMteric(metric);
    	return metric;
	}
	
//	double bidAvg = getBidTotal()/getBids().size();
//
//
//	if(bidAvg>getAsk()) {
//		setMteric(1);
//		return 1;
//	}else if(bidAvg<getAsk()) {
//		setMteric(-1);
//		return -1;
//	}else{
//		setMteric(0);
//		return 0;
//	}
	
	



	
}
