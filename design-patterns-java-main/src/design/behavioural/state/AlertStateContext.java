package design.behavioural.state;

// This will set the internal state of Alert for Mobile object and change the behaviour at runtime
// Avoid lots of If -else
public class AlertStateContext {

    MobileAlertState mobileAlertState;

    // Setting the default state
    public AlertStateContext() {
        this.mobileAlertState = new Vibration();
    }

    public void setMobileAlertState(MobileAlertState mobileAlertState) {
        this.mobileAlertState = mobileAlertState;
    }

    public void alert() {
        mobileAlertState.alert(this);
    }

}
