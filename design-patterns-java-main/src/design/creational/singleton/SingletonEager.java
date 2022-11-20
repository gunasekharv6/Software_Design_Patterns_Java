package design.creational.singleton;

public class SingletonEager {

    // Created When the class loads -> class level static
    private static final SingletonEager instance = new SingletonEager();

    // Private Constructor
    private SingletonEager() {

    }

    public static SingletonEager getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "SingletonEager Object is Created";
    }
}
