package design.behavioural.strategy;

public class RunFast implements RunStrategy {

    @Override
    public void run() {
        System.out.println("******** Running Fast **** => " + this.getClass().getSimpleName());
    }
}
