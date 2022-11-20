package design.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

//This is publishing repo
public class CricketDataRepo implements Subject {

    int runs;
    int wickets;
    float overs;

    // Maintain a list of Observers
    List<Observer> ol = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        ol.add(o);
    }

    @Override
    public void unRegisterObserver(Observer o) {
        ol.remove(o);
    }

    @Override
    public void notifyObservers() {

        for (Observer item : ol) {
            item.update(runs, wickets, overs);
        }
    }

    // For Simplicity I AM USING HARDCODED Values
    public int getLatestWickets() {
        return 5;
    }

    public int getLatestRuns() {
        return 150;
    }

    public float getLatestOvers() {
        return (float) 20.55;
    }

    // Check if new data is arrived
    public void changeData() {

        this.runs = getLatestRuns();
        this.wickets = getLatestWickets();
        this.overs = getLatestOvers();

        notifyObservers();
    }
}
