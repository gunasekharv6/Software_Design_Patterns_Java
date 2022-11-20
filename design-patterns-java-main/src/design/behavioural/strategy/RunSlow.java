package design.behavioural.strategy;

public class RunSlow implements RunStrategy {
    @Override
    public void run() {
        System.out.println("********* Running Slow => " + this.getClass().getSimpleName());
    }
}
