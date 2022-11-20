package design.behavioural.strategy;

// Generic Class -> Cannot create Object -> Make it abstract

public abstract class Animal {

    // Animals Run, but they have a lot of different run algorithms/strategies
    // Abstract the RunStrategy
    private RunStrategy runStrategy;

    // Setting the Run Strategy
    public void setRunStrategy(RunStrategy runStrategy) {
        this.runStrategy = runStrategy;
    }

    // Execute the strategy
    public void performRun() {
        runStrategy.run();
    }

    public abstract void display();

}
