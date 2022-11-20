package design.behavioural.command;

public class Driver {

    public static void main(String[] args) {

        // Get the command controller
        CommandController c = new CommandController();

        // Set Light on Command
        c.setCommand(new LightOnCommand(new Light()));
        // Execute the commands
        c.execute();

        // Set Light Off Command
        c.setCommand(new LightOffCommand(new Light()));
        // Execute the commands
        c.execute();


    }
}
