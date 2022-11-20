public class SumCommand implements CommandAPI{
    ReceiverAPI receiver;

    public SumCommand(ReceiverAPI receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("The Sum Command's result: " + receiver.sum());
    }
}