package design.structural.adaptor;

public class Main {

    public static void main(String[] args) {
        // Creating Objects
        Bird parrot = new Parrot();
        System.out.println("I am ====> " + parrot.getClass().getSimpleName());
        parrot.fly();
        parrot.makeSound();
        System.out.println();

        ToyBird wd = new WoodenDuck();
        System.out.println("I am ====> " + wd.getClass().getSimpleName());
        wd.squak();
        System.out.println();

        System.out.println("******* Adaptor in Action ***********");
        // wrap legacy bird parrot in Adaptor
        System.out.println("***** Making Interfaces Compatible *******");
        ToyBird adaptedBird = new BirdAdaptor(parrot);
        System.out.println("I am ====> " + adaptedBird.getClass().getSimpleName());
        adaptedBird.squak();
    }

}
