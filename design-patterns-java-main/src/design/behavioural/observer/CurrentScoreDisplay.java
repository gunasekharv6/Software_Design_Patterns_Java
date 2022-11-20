package design.behavioural.observer;

public class CurrentScoreDisplay implements Observer {

    int runs;
    int wickets;
    float overs;

    // Setting the current values
    @Override
    public void update(int runs, int wickets, float overs) {
        this.overs = overs;
        this.runs = runs;
        this.wickets = wickets;
        display();
    }

    public void display() {
        System.out.println("\nCurrent Score Display:\n"
                + "Runs: " + runs +
                "\nWickets:" + wickets +
                "\nOvers: " + overs);
    }
}
