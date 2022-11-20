package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockMarket {
	Scanner scanner = new Scanner(System.in);
	private static StockMarket instance=null;
	private List<Tradable> stocklist;

	private StockMarket() {
		super();
		stocklist = new ArrayList<>();
	}
	
	public static StockMarket getInstance() {
		if (instance==null) {
			synchronized(StockMarket.class) {
				if(instance==null) {
					instance = new StockMarket();
				}
			}
		}
		
		return instance;
	}
	
	
	public void addStock(Tradable adapter) {
		this.stocklist.add(adapter);
	}
	
	public boolean removeStock(StockAPI s) {
		return this.stocklist.remove(s);
	}
	
	public void trade(StockAPI s) {
		if(!this.stocklist.contains(s)){
			this.stocklist.add(s);
		}
		int metric = s.getMetric();

		if(metric>0){
			s.setPrice(2*s.getPrice()); //Increasing the price of the stock
			System.out.println("Stock is performing good. Do you want to INCREASE the ask price? y or n");
			String c = scanner.nextLine();
//			scanner.nextLine();
			if (c.equalsIgnoreCase("y")){
				System.out.println("Enter the new ask price");
				Double d = scanner.nextDouble();
				scanner.nextLine();
				while(d<s.getAsk()){
					System.out.println("You have entered a lower ask price than before.");
					System.out.println("Since the stock is performing well, we suggest you to INCREASE your ask price.");
					System.out.println("Enter the new ask price");
					d = scanner.nextDouble();
					scanner.nextLine();
				}
				s.setAsk(d);
				System.out.println(s.toString());
			}
			else{
				System.out.println("Your ask price remains as it is");
				System.out.println(s.toString());
			}
		}
		else if(metric<0){
			s.setPrice(0.5*s.getPrice()); //Decreasing the price of the stock
			System.out.println("Stock is not performing good. Do you want to DECREASE the ask price? y or n");
			String c = scanner.nextLine();
			if(!c.equalsIgnoreCase("y"))
			{
				System.out.println("Your ask price remains as it is");
				System.out.println(s.toString());
			}
//			(c.equalsIgnoreCase("y"))
			else {
				System.out.println("Enter the new ask price");
				Double d = scanner.nextDouble();
				scanner.nextLine();
				while(d>s.getAsk()){
					System.out.println("You have entered a higher ask price than before.");
					System.out.println("Since the stock is not performing well, we suggest you to DECREASE your ask price.");
					System.out.println("Enter the new ask price");
					d = scanner.nextDouble();
					scanner.nextLine();
				}
				s.setAsk(d);
				System.out.println(s.toString());
			}
		}
		else{
			System.out.println("Stock is performing normal. We suggest you to not change the ask price");
			System.out.println(s.toString());
			return;	//Price of the stock remains constant
		}
	}

	public void showStocksStatus(){
		for(Tradable s: this.stocklist){
			System.out.println(s.toString());
			System.out.println();
		}
	}

	public static void demo(){
		StockMarket nasdaq = StockMarket.getInstance();
		
		LegacyTradable amazon = new Amazon("Amazon", 100, "Amazon Stocks", 90);
		Tradable adapter = new StockAdapter(amazon);
		

		
//************************** GoF Factory and non-Singleton ****************************
		// GoF Factory Design Pattern for Factory Classes
		AbstractFactory walmartFactory = new WalmartFactory();
		AbstractFactory costcoFactory = new CostcoFactory();

		// Generating derived class objects using Factory class instances
		StockAPI wm = walmartFactory.getObject();
		{
			wm.setName("Walmart US");
			wm.setPrice(100.01);
			wm.setDescription("Walmart US stock");
			wm.setAsk(90.01);
			wm.setStrategy(new Bull());
		}
		// Generating derived class objects using Factory class instances
		StockAPI costco = costcoFactory.getObject();
		{
			costco.setName("Costco US");
			costco.setPrice(200.10);
			costco.setDescription("Costco US stock");
			costco.setAsk(181.20);
			costco.setStrategy(new Bear());
		}

//************************** GoF Factory and Singleton ****************************

		// GoF Factory Design Pattern for Factory Classes using Singleton pattern
		AbstractFactory walmartFactorySingleton = WalmartFactorySingleton.getInstance();
		AbstractFactory costcoFactorySingleton = CostcoFactorySingleton.getInstance();

		// Generating derived class objects using Factory class instances
		StockAPI wmSingleton = walmartFactorySingleton.getObject();
		{
			wmSingleton.setName("Walmart India");
			wmSingleton.setPrice(90.01);
			wmSingleton.setDescription("Walmart Indian stock");
			wmSingleton.setAsk(85.01);
			wmSingleton.setStrategy(BullSingleton.getInstance());
		}

		// Generating derived class objects using Factory class instances
		StockAPI costcoSingleton = costcoFactorySingleton.getObject();
		{
			costcoSingleton.setName("Costco India");
			costcoSingleton.setPrice(180.10);
			costcoSingleton.setDescription("Costco Indian stock");
			costcoSingleton.setAsk(171.20);
			costcoSingleton.setStrategy(BearSingleton.getInstance());
		}

//		Adding stocks to StockMarket "nasdaq" instance
		nasdaq.addStock(wm);
		System.out.println("Walmart US stock added to nasdaq successfully");
		nasdaq.addStock(costco);
		System.out.println("Costco US stock added to nasdaq successfully");

		nasdaq.addStock(wmSingleton);
		System.out.println("Walmart Indian stock added to nasdaq successfully");
		nasdaq.addStock(costcoSingleton);
		System.out.println("Costco Indian stock added to nasdaq successfully");
//		Adding Adapter stock to the stockmarket 
		nasdaq.addStock(adapter);
		System.out.println("Amazon stock added to nasdaq successfully");
		System.out.println();
		
		
// Adding bids to stocks
		System.out.println("Adding bids to Walmart US stock");
		for(int i=1; i<=6; i++){
			double n = 85+Math.random()*10;
			wm.setBid(n);
			System.out.println("Bid amount added to Walmart US: "+n);
		}
		wm.getMetric();
		System.out.println("Average Bid Value: "+wm.getBidTotal()/wm.getBidCounter());


		System.out.println();

		System.out.println("Adding bids to Costco US stock");
		for(int i=1; i<=6; i++){
			double n = 180+Math.random()*10;
			costco.setBid(n);
			System.out.println("Bid amount added to Costco US: "+n);
		}
		costco.getMetric();
		System.out.println("Average Bid Value: "+costco.getBidTotal()/costco.getBidCounter());

		System.out.println();

		System.out.println("Adding bids to Walmart Indian stock");
		for(int i=1; i<=6; i++){
			double n = 80+Math.random()*10;
			wmSingleton.setBid(n);
			System.out.println("Bid amount added to Walmart India: "+n);
		}
		wmSingleton.getMetric();
		System.out.println("Average Bid Value: "+wmSingleton.getBidTotal()/wmSingleton.getBidCounter());


		System.out.println();

		System.out.println("Adding bids to Costco Indian stock");
		for(int i=1; i<=6; i++){
			double n = 165+Math.random()*10;
			costcoSingleton.setBid(n);
			System.out.println("Bid amount added to Costco India: "+n);
		}
		costcoSingleton.getMetric();
		System.out.println("Average Bid Value: "+costcoSingleton.getBidTotal()/costcoSingleton.getBidCounter());



		System.out.println("Status of nasdaq stocks:");
		nasdaq.showStocksStatus();

		System.out.println("Choose 1 to trade Walmart US stocks - non Singleton");
		System.out.println("Choose 2 to trade Costco US stocks - non Singleton");
		System.out.println("Choose 3 to trade Walmart Indian stocks - Singleton");
		System.out.println("Choose 4 to trade Costco Indian stocks - Singleton");
		System.out.println("Choose 5 to trade Amazon stocks - Adaper Design Pattern");


		int l = nasdaq.scanner.nextInt();
		nasdaq.scanner.nextLine();
		if(l==1){
			System.out.println("Trading walmart US stocks");
			nasdaq.trade(wm);
//			System.out.println();
			return;
		}
		else if(l==2){
			System.out.println("Trading Costco US stocks");
			nasdaq.trade(costco);
//			System.out.println();
		}
		else if(l==3){
			System.out.println("Trading walmart Indian stocks");
			nasdaq.trade(wmSingleton);
//			System.out.println();
			return;
		}
		else if(l==4){
			System.out.println("Trading Costco Indian stocks");
			nasdaq.trade(costcoSingleton);
//			System.out.println();
			return;
		}
		else if(l==5){
			System.out.println("Trading Amazon stocks");
			nasdaq.trade((StockAPI)adapter);
//			System.out.println();
			return;
		}
		else{
			System.out.println("Sorry you have entered a wrong number");
		}
	}
}
