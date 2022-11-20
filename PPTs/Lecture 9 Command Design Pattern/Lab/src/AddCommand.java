public class AddCommand implements CommandAPI{
    ReceiverAPI receiver;

    public AddCommand(ReceiverAPI receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("The Add Command's result: " + receiver.add());
    }
}
