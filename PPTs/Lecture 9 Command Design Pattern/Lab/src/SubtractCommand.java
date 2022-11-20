public class SubtractCommand implements CommandAPI{
    ReceiverAPI receiver;

    public SubtractCommand(ReceiverAPI receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        System.out.println("The Subtract Command's result: " + receiver.subtract());
    }
}
