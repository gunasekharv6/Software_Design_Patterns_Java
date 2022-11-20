package edu.neu.csye7374;

public class AntiLockBrakingSystem  extends AutoDecorator{
	
public static final int price=2600;
public static final String  description= " comes with Anti Lock Braking System";
public final AutoAPI autoAPI;

public AntiLockBrakingSystem(AutoAPI obj) {
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
	return "AntiLockBrakingSystem [Price=$" + getPrice() + ", Description=" + getDescription() + "]";
}
	


}