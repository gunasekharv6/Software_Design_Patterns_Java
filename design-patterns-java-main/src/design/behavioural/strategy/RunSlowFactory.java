package design.behavioural.strategy;

public class RunSlowFactory implements RunStrategyFactory{
    @Override
    public RunStrategy getObject() {
        return new RunSlow();
    }
}
