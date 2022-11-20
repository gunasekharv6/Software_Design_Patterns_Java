package edu.neu.csye7374;

public class BumperToBumper extends AutoDecorator{
	
public static final int price=5215;
public static final String  description= " , exclusive Bumper to Bumper Warranty";
public final AutoAPI autoAPI;

public BumperToBumper(AutoAPI obj) {
	        this.autoAPI=obj;
}

@Override
  public int getPrice() {
	  return autoAPI.getPrice()+price;
  }
  
@Override
  public String getDescription() {
	  return autoAPI.getDescription()+description;
  }

@Override
public String toString() {
	return "BumperToBumper [Price=$" + getPrice() + ", Description=" + getDescription() + "]";
}


	
}