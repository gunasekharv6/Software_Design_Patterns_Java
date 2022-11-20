package design.behavioural.command;

public class CommandController {

    // Single Command button
    Command command;

    // Setting the command
    public void setCommand(Command command) {
        this.command = command;
    }

    // Executing the command
    public void execute(){
        command.execute();
    }
}
