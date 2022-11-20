package design.behavioural.strategy;

public class RunFastFactory implements RunStrategyFactory {

    @Override
    public RunStrategy getObject() {
        return new RunFast();
    }
}
