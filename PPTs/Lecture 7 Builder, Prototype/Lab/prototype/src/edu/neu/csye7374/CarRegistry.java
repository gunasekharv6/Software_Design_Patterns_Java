package edu.neu.csye7374;

import java.util.HashMap;
import java.util.Map;

public class CarRegistry {

    private static Map<String, Car> registry = new HashMap<>();

    static {
        registry.put("SUV", new SUV());
        registry.put("Sedan", new Sedan());
    }

    public static Car getCarType(String carType) {
        return (Car) registry.get(carType).clone();
    }
    
    
    public static void demo() {
    	CarRegistry.getCarType("SUV").display();
        CarRegistry.getCarType("Sedan").display();
        CarRegistry.getCarType("Sedan").display();
    }


}
