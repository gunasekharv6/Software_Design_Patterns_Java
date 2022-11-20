package design.structural.adaptor;

public interface Bird {

    // This is the Legacy interface
    // In the system for many years - we need to adapt this
    // Also called as Adaptee

    public void fly();

    public void makeSound();

}
