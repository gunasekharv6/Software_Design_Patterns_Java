package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockAPI implements Tradable, Comparable<StockAPI>{
	private String name;
	private double price;
	private String description;
	private double ask;
	private List<Double> bids;
	private double bidTotal;
	private int bidCounter;
	private int mteric;


	public StockAPI() {
		this.bids = new ArrayList<>();
		this.bidCounter = 0;
		this.mteric=0;
	}

	public StockAPI(String name, double price, String description, double ask) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.ask = ask;

	}


	public void setBid(double bid) {

		if(bidCounter==6){
			this.bids.clear();
			bidCounter=0;
			bidTotal=0;
			return;
		}

		this.bids.add(bid);
		this.bidTotal+=bid;
		this.bidCounter++;
	}


	public int getMetric() {
		double bidAvg = bidTotal/this.bids.size();


		if(bidAvg>ask) {
			setMteric(1);
			return 1;
		}else if(bidAvg<ask) {
			setMteric(-1);
			return -1;
		}else{
			setMteric(0);
			return 0;
		}
	}

	@Override
	public String toString() {
		return "StockAPI{" +
				"name='" + name + '\'' +
				", price=" + price +
				", description='" + description + '\'' +
				", ask=" + ask +
				", totalValueOfBids=" + bidTotal +
				", numberOfBids=" + bidCounter +
				", metric="+getMteric()+
				'}';
	}

	//*******Getters and setters*********
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public double getAsk() {
		return ask;
	}


	public void setAsk(double ask) {
		this.ask = ask;
	}


	public double getBid() {
		return this.bidTotal;
	}

	public List<Double> getBids() {
		return bids;
	}

//	public void setBids(List<Double> bids) {
//		this.bids = bids;
//	}

	public double getBidTotal() {
		return bidTotal;
	}

	public void setBidTotal(double bidTotal) {
		this.bidTotal = bidTotal;
	}

	public int getBidCounter() {
		return bidCounter;
	}

	public void setBidCounter(int bidCounter) {
		this.bidCounter = bidCounter;
	}

	public int getMteric() {
		return mteric;
	}

	public void setMteric(int mteric) {
		this.mteric = mteric;
	}

	@Override
	public int compareTo(StockAPI o) {
		return o.getName().compareToIgnoreCase(this.getName());
	}
}
