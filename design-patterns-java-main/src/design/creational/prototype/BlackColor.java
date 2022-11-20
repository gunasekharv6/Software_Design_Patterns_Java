package design.creational.prototype;

public class BlackColor extends Color {

    public BlackColor() {
        this.colorName = "BLACK";
    }

    @Override
    public void display() {
        System.out.println("******** This is Black Color **** " + this.hashCode());
    }
}
