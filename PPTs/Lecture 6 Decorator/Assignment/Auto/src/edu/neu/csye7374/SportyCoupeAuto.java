package edu.neu.csye7374;

public class SportyCoupeAuto implements AutoAPI{
	
	private final int price = 250000;
	private final String carName = "This is an artistic Bugatti";

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public String getDescription() {
		return carName;
	}

	@Override
	public String toString() {
		return "SportyCoupeAuto [price=$" + price + ", carName=" + carName + "]";
	}
	
	

}
