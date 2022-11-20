package edu.neu.csye7374;

public class AirConditioning extends AutoDecorator{
	
public static final int price=1200;
public static final String  description= ", fully Air Conditioned";
public final AutoAPI autoAPI;

public AirConditioning(AutoAPI obj) {
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
	return "AirConditioning [Price=$" + getPrice() + ", Description=" + getDescription() + "]";
}
	

}
