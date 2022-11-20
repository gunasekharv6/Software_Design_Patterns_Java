package edu.neu.csye7374;

public abstract class Car implements Cloneable {

    String carType;

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
