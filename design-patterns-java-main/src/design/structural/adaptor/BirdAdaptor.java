package design.structural.adaptor;

// We will Implement out target interface here as Client will use it

public class BirdAdaptor implements ToyBird {

    // At the same time we will use it to compose our Adaptee or Legacy interface
    // here
    // to make it compatible to use for our client

    Bird bird;

    public BirdAdaptor(Bird bird) {
        super();
        this.bird = bird;
    }

    @Override
    public void squak() {

        // Bird will make the sound Now using ToyBird
        bird.makeSound();

    }
}
