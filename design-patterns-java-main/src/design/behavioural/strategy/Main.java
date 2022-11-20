package design.behavioural.strategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Get the Run Strategies
        RunStrategyFactory r1 = new RunFastFactory();
        RunStrategyFactory r2 = new RunSlowFactory();

        RunStrategy k1 = r1.getObject();
        RunStrategy k2 = r2.getObject();

        // Get the Animals and set their Strategies
        Animal dog = new Dog();
        Animal turtle = new Turtle();

        dog.setRunStrategy(k1);
        turtle.setRunStrategy(k2);

        List<Animal> animalList = new ArrayList<>();
        animalList.add(dog);
        animalList.add(turtle);

        for (Animal a : animalList) {
            a.display();
            a.performRun();
        }


    }
}
