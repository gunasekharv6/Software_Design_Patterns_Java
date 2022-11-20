package design.creational.prototype;

public class RedColor extends Color{

    public RedColor() {
        this.colorName = "RED";
    }

    @Override
    public void display() {
        System.out.println("******** This is Red Color ******* " + this.hashCode());
    }
}
