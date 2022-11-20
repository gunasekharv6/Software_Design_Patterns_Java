package design.structural.adaptor;

public class Parrot implements Bird {
    @Override
    public void fly() {
        System.out.println("******** I am Flying *********");
    }

    @Override
    public void makeSound() {
        System.out.println("************ Chirp Chirp ************");
    }
}
