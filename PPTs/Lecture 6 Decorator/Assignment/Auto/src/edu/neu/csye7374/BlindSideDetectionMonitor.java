package edu.neu.csye7374;

public class BlindSideDetectionMonitor extends AutoDecorator{
	
public static final int price=1200;
public static final String  description= " , and a Blind Side Detection Monitor";
public final AutoAPI autoAPI;

public BlindSideDetectionMonitor(AutoAPI obj) {
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
	return "BlindSideDetectionMonitor [Price=$" + getPrice() + ", Description=" + getDescription() + "]";
}


	
}