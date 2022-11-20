public class MultiplyCommand implements CommandAPI{
    ReceiverAPI receiver;

    public MultiplyCommand(ReceiverAPI receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("The Multiply Command's result: " + receiver.multiply());
    }
}
