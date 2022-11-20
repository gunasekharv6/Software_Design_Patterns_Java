public class Client {
    public static void demo(){
        Invoker invoker = new Invoker();
        // 2 Digit Multiplier
        ReceiverAPI twoDigitReceiver = new TwoDigitReceiver(6, 3);

        // Add Command
        System.out.println("Demonstrating ADDITION of 6 & 3");
        CommandAPI addCommand = new AddCommand(twoDigitReceiver);
        invoker.setCommand(addCommand).invoke();
        System.out.println();

        // Subtract Command
        System.out.println("Demonstrating SUBTRACTION of 3 from 6");
        CommandAPI subtractCommand = new SubtractCommand(twoDigitReceiver);
        invoker.setCommand(subtractCommand).invoke();
        System.out.println();

        // Multiply Command
        System.out.println("Demonstrating MULTIPLICATION of 6 & 3");
        CommandAPI multiplyCommand = new MultiplyCommand(twoDigitReceiver);
        invoker.setCommand(multiplyCommand).invoke();
        System.out.println();

        // Divide Command
        System.out.println("Demonstrating DIVISION of 6 by 3");
        CommandAPI divideCommand = new DivideCommand(twoDigitReceiver);
        invoker.setCommand(divideCommand).invoke();
        System.out.println();

        // 4 Digit Multiplier
        ReceiverAPI fourDigitReceiver = new FourDigitReceiver(1, 2, 3, 4);
        // Sum Command
        System.out.println("Demonstrating SUMMATION of 1,2,3,4");
        CommandAPI sumCommand = new SumCommand(fourDigitReceiver);
        invoker.setCommand(sumCommand).invoke();
        System.out.println();
    }
}
