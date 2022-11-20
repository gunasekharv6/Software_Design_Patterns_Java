package design.behavioural.state;

public class Silent implements MobileAlertState{
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("******* Mobile is in  Silent State *********");
    }
}
