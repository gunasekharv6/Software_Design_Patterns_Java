package edu.neu.csye7374;

public class AllWheelDrive extends AutoDecorator{
	
public static final int price=3500;
public static final String  description= " , with exotic All Wheel Drive";
public final AutoAPI autoAPI;

public AllWheelDrive(AutoAPI obj) {
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
	return "AllWheelDrive [Price=$" + getPrice() + ", Description=" + getDescription() + "]";
}


	
}
