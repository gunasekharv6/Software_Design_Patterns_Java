package design.behavioural.state;

public class Driver {

    public static void main(String[] args) {

        // Mobil Alert state is Default -> Vibration
        AlertStateContext ctx = new AlertStateContext();
        ctx.alert();
        ctx.alert();

        // Changing state to Silent
        // Change Behaviour at runtime
        ctx.setMobileAlertState(new Silent());
        ctx.alert();
        ctx.alert();


    }

}

