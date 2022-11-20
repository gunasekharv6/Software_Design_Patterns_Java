package edu.neu.csye7374;

public class ShowDecoratedAuto {
	
	public static void demo() {
		System.out.println("Base Car");
		System.out.println(new SportyCoupeAuto());
		System.out.println();
		
		System.out.println("Car with AirConditioning");
		System.out.println(new AirConditioning(new SportyCoupeAuto()));
		System.out.println();
		
		System.out.println("Car with AntiLockBrakingSystem, BumperToBumper and BlindSideDetectionMonitor");
		AutoAPI autoAPI = new SportyCoupeAuto();
		autoAPI = new BlindSideDetectionMonitor(new BumperToBumper(new AntiLockBrakingSystem(autoAPI)));
		System.out.println(autoAPI);
		System.out.println();

		System.out.println("Car with AllWheelDrive");
		System.out.println(new AllWheelDrive(new SportyCoupeAuto()));
		System.out.println();
		
		System.out.println("Car with AirConditioning and AllWheelDrive");
		System.out.println(new AllWheelDrive(new AirConditioning(new SportyCoupeAuto())));
		System.out.println();

	}

}
