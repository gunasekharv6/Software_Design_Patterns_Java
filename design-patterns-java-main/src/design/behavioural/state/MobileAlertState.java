package design.behavioural.state;

// this is the main interface for state.
// Mobile can have 1000 states. All the concrete states will implement this interface
// it has a handle (Alert)
public interface MobileAlertState {

    public void alert(AlertStateContext ctx);

}
