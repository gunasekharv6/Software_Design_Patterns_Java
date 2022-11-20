package edu.neu.csye7374;

import java.util.List;

public class StockAdapter extends StockAPI implements Tradable{
	
	private LegacyTradable legacyStock;
	private List<Double> quotes;
	
	
	
	public StockAdapter(LegacyTradable legacyStock) {
		super();
		this.legacyStock = legacyStock;
		this.quotes = legacyStock.buyersQuotes();
	}
	

//	private void populateBids() {
//		this.quotes=legacyStock.buyersQuotes();
//	}
	

	@Override
	public int getMetric() {
		int perf = legacyStock.performance();
		legacyStock.setMteric(perf);
		return perf;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Tradable{" +
				"name='" + getName() + '\'' +
				", price=" + getPrice() +
				", description='" + getDescription() + '\'' +
				", ask=" + getAsk() +
				", avgBidValue=" + (getBidTotal()/getBidCounter()) +
				", numberOfBids=" + getBidCounter() +
				", metric="+getMteric()+
				'}';
	}


	public String getName() {
		return legacyStock.getName();
	}


	public void setName(String name) {
		legacyStock.setName(name);
	}


	public double getPrice() {
		return legacyStock.getPrice();
	}


	public void setPrice(double price) {
		legacyStock.setPrice(price);
	}


	public String getDescription() {
		return legacyStock.getDescription();
	}


	public void setDescription(String description) {
		legacyStock.setDescription(description);
	}

	public double getAsk() {
		return legacyStock.getAsk();
	}


	public void setAsk(double ask) {
		legacyStock.setAsk(ask);
	}


	public double getBid() {
		return legacyStock.getBidTotal();
	}

	public List<Double> getBids() {
		return legacyStock.getBids();
	}

//	public void setBids(List<Double> bids) {
//		this.bids = bids;
//	}

	public double getBidTotal() {
		return legacyStock.getBidTotal();
	}

	public void setBidTotal(double bidTotal) {
		legacyStock.setBidTotal(bidTotal);
	}

	public int getBidCounter() {
		return legacyStock.getBidCounter();
	}

	public void setBidCounter(int bidCounter) {
		legacyStock.setBidCounter(bidCounter);
	}

	public int getMteric() {
		return legacyStock.getMteric();
	}

	public void setMteric(int mteric) {
		legacyStock.setMteric(mteric);
	}

}
