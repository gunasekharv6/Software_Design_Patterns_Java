package design.creational.factory;

public class Main {

    public static void main(String[] args) {

        // Factory Abstraction
        StockFactory factory = new GoogleFactory();

        // Get the Object from factory -> Hides How, when, what Object it creates
        Stock k = factory.getObject();

        // Display the Object
        k.dispaly();

    }

}
