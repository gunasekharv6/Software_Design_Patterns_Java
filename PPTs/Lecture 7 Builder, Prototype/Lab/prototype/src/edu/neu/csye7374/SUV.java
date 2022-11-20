package edu.neu.csye7374;

public class SUV extends Car{

    public SUV() {
        this.carType = "SUV";
    }

    @Override
    public void display() {
        System.out.println("******** This is an SUV ******* " + this.hashCode());
    }
}
