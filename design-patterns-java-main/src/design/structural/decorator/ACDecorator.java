package design.structural.decorator;

public class ACDecorator extends AutoAPIDecorator{

    public ACDecorator(AutoAPI api) {
        super(api);
    }

    @Override
    public double getPrice(){
        price = api.getPrice();

        System.out.println("********* Adding AC DECORATION ********");
        return addAC(price);
    }

    private double addAC(double price) {
        System.out.println("******** Price before Adding AC ====> " + price);
        double newPrice =  price + 25.00;
        System.out.println("******** Price After Adding AC ====> " + newPrice);
        return newPrice;
    }

    public String getDescription(){
        description = api.getDescription();
        return description + " Added AC -> ";
    }
}
