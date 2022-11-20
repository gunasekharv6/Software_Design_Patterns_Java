package design.creational.singleton;

public class SingletonBest {

    private static volatile SingletonBest instance;

    private SingletonBest() {

    }

    public static SingletonBest getInstance() {

        // First Chcek
        if (instance == null) {

            synchronized (SingletonBest.class) {

                // Second Check as Many threads can pass First Check
                if (instance == null) {
                    instance = new SingletonBest();
                }

            }

        }

        return instance;
    }

    @Override
    public String toString() {
        return "SingleTon Best Object";
    }
}
