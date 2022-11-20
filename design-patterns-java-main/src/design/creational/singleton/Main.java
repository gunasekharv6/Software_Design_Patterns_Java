package design.creational.singleton;

public class Main {

    public static void main(String[] args) {

        SingletonEager e = SingletonEager.getInstance();
        System.out.println(e);

        System.out.println(SingletonLazy.getInstance());

        System.out.println(SingletonBest.getInstance());
    }
}
