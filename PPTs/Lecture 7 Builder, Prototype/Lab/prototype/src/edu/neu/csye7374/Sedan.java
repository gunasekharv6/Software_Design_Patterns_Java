package edu.neu.csye7374;

public class Sedan extends Car {

    public Sedan() {
        this.carType = "Sedan";
    }

    @Override
    public void display() {
        System.out.println("******** This is HondaCity **** " + this.hashCode());
    }
}
