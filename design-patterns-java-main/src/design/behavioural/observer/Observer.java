package design.behavioural.observer;

// This interface is implemented by all those
// classes that are to be updated whenever there
// is an update from Publisher (CricketRepo)
public interface Observer {

    public void update(int runs, int wickets, float overs);


}
