package neu;

public class Main {

	public static void main(String[] args) {
		byte byteValue = 10;
		short shortValue = 20;
		int intValue = 50;
		long longTotal = 50000L + 10L * (byteValue + shortValue + intValue);
		System.out.println(longTotal);
		
		float myMinFloatValue = Float.MIN_VALUE;
		float myMaxFloatValue = Float.MAX_VALUE;
		System.out.println("Float minimum value: "  +myMinFloatValue);
		System.out.println("Flot maximum value: " +myMaxFloatValue);
		
		int myIntValue = 5/3;
		float myFloatValue = 5f / 3f;
		double myDoubleValue = 5d /3d;
		
		System.out.println("MyIntValue: " +myIntValue);
		System.out.println("MyFloatValue: " +myFloatValue);
		System.out.println("MyDoubleValue: " +myDoubleValue);
		
		double numberOfPounds = 100;
		double convertedKilo = numberOfPounds * 0.45359237;
		System.out.println("Converted Kilograms: " +convertedKilo);
		

	}

}
