package design.behavioural.observer;

public class Driver {

    public static void main(String[] args) {

        // Define the Subject
        Subject sub = new CricketDataRepo();

        AverageScoreDisplay asd = new AverageScoreDisplay();
        CurrentScoreDisplay csd = new CurrentScoreDisplay();
        // Register the Observers
        sub.registerObserver(asd);
        sub.registerObserver(csd);

        // When your data is changed
        sub.changeData();

        // Remove an Observer
        sub.unRegisterObserver(asd);

        // now only currentScoreDisplay gets the
        // notification
        sub.changeData();
    }
}
