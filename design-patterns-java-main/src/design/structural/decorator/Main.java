package design.structural.decorator;

public class Main {


    public static void main(String[] args) {

        AutoAPI initialCar = new Lamborgini();

        System.out.println("Initial Car Price ====> " + initialCar.getPrice());
        System.out.println("Initial Car Description ====> " + initialCar.getDescription());

        System.out.println("==================");
        System.out.println();

        //Adding AC | ABS -> Decorator Chaining
        AutoAPI finalCar = new ABSDecorator(new ACDecorator(initialCar));

        System.out.println("Final Car Price ====> " + finalCar.getPrice());
        System.out.println("Final Car Description ====> " + finalCar.getDescription());

    }


}
