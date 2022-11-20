package design.behavioural.command;

// This is the receiver with ops
// Add corresponding receiver commands that implements Command Interface
public class Light {

    public void on() {
        System.out.println("Light is On");
    }

    public void off() {
        System.out.println("Light is Off");
    }

}
