package design.behavioural.observer;

// This is the Publisher that communicates with Subscribers/Observers
public interface Subject {

    public void registerObserver(Observer o);
    public void unRegisterObserver(Observer o);
    public void notifyObservers();
    public void changeData();
}
