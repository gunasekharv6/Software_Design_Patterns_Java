package edu.neu.csye7374;

public abstract class AutoDecorator implements AutoAPI {

	@Override
	public int getPrice() {
		return 2000;
	}

	@Override
	public String getDescription() {
		return "This is a brand new Car";
	}

}
