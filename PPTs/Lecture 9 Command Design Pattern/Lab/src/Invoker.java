public class Invoker {
    private CommandAPI command;

    public Invoker() {
    }

    public Invoker(CommandAPI command) {
        this.command = command;
    }

    public Invoker setCommand(CommandAPI command){
        this.command = command;
        return this;
    }

    public void invoke(){
        try{
            command.execute();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Please set a command");
        }

    }
}