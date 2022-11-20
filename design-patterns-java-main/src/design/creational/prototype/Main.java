package design.creational.prototype;

// This design pattern is used to create objects from existing objects
// Prototype design pattern is used when the object creation process is costly.
// This will save the time and resources for object creation
public class Main {

    public static void main(String[] args) {

        ColorRegistry.getColor("BLACK").display();
        ColorRegistry.getColor("RED").display();
        ColorRegistry.getColor("RED").display();
    }

}
