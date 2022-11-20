package design.behavioural.state;

public class Vibration implements MobileAlertState {
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("****** Mobile is in Vibration State *******");
    }
}
