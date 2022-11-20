package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockMarket {
	Scanner scanner = new Scanner(System.in);
	private static StockMarket instance=null;
	private List<StockAPI> stocklist;

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
	
	
	public void addStock(StockAPI s) {
		this.stocklist.add(s);
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
			System.out.println("Stock is performing good. Do you want to increase the ask price? y or n");
			String c = scanner.nextLine();
//			scanner.nextLine();
			if (c.equalsIgnoreCase("y")){
				System.out.println("Enter the new ask price");
				Double d = scanner.nextDouble();
				scanner.nextLine();
				while(d<s.getAsk()){
					System.out.println("You have entered a lower ask price than before.");
					System.out.println("Since the stock is performing well, we suggest you to increase your ask price.");
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
		else if(metric<=0){
			s.setPrice(0.5*s.getPrice()); //Decreasing the price of the stock
			System.out.println("Stock is not performing good. Do you want to decrease the ask price? y or n");
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
					System.out.println("Since the stock is not performing well, we suggest you to decrease your ask price.");
					System.out.println("Enter the new ask price");
					d = scanner.nextDouble();
					scanner.nextLine();
				}
				s.setAsk(d);
				System.out.println(s.toString());
			}
		}
		else{
			System.out.println(s.toString());
			return;	//Price of the stock remains constant
		}
	}

	public void showStocksStatus(){
		for(StockAPI s: this.stocklist){
			System.out.println(s.toString());
			System.out.println();
		}
	}

	public static void demo(){
		StockMarket nasdaq = StockMarket.getInstance();
//************************** GoF and non-Singleton ****************************
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
		}
		// Generating derived class objects using Factory class instances
		StockAPI costco = costcoFactory.getObject();
		{
			costco.setName("Costco US");
			costco.setPrice(200.10);
			costco.setDescription("Costco US stock");
			costco.setAsk(181.20);
		}

//************************** GoF and Singleton ****************************

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
		}

		// Generating derived class objects using Factory class instances
		StockAPI costcoSingleton = costcoFactorySingleton.getObject();
		{
			costcoSingleton.setName("Costco India");
			costcoSingleton.setPrice(180.10);
			costcoSingleton.setDescription("Costco Indian stock");
			costcoSingleton.setAsk(171.20);
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
		System.out.println();

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
			double n = 85+Math.random()*10;
			wmSingleton.setBid(n);
			System.out.println("Bid amount added to Walmart India: "+n);
		}
		wmSingleton.getMetric();
		System.out.println("Average Bid Value: "+wmSingleton.getBidTotal()/wmSingleton.getBidCounter());


		System.out.println();

		System.out.println("Adding bids to Costco Indian stock");
		for(int i=1; i<=6; i++){
			double n = 180+Math.random()*10;
			costcoSingleton.setBid(n);
			System.out.println("Bid amount added to Costco India: "+n);
		}
		costcoSingleton.getMetric();
		System.out.println("Average Bid Value: "+costcoSingleton.getBidTotal()/costcoSingleton.getBidCounter());



		System.out.println("Status of nasdaq stocks:");
		nasdaq.showStocksStatus();

		System.out.println("Choose 1 to trade Walmart US stocks");
		System.out.println("Choose 2 to trade Costco US stocks");
		System.out.println("Choose 3 to trade Walmart Indian stocks");
		System.out.println("Choose 4 to trade Costco Indian stocks");


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
		else{
			System.out.println("Sorry you have entered a wrong number");
		}
	}
}
