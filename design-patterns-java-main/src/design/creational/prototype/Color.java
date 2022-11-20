package design.creational.prototype;

public abstract class Color implements Cloneable {

    String colorName;

    public abstract void display();

    public Object clone() {

        Object clone = null;

        try {

            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
