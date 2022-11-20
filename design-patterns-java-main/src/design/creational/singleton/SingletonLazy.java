package design.creational.singleton;

public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy() {

    }

    // Make it thread safe -> less performant
    public synchronized static SingletonLazy getInstance() {

        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Singleton Lazy Object is Created";
    }
}
