public class DivideCommand implements CommandAPI{
    ReceiverAPI receiver;

    public DivideCommand(ReceiverAPI receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("The Divide Command's result: " + receiver.divide());
    }
}
