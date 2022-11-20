package design.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class ColorRegistry {

    private static Map<String, Color> registry = new HashMap<>();

    static {
        registry.put("RED", new RedColor());
        registry.put("BLACK", new BlackColor());
    }

    public static Color getColor(String colorName) {
        return (Color) registry.get(colorName).clone();
    }


}
