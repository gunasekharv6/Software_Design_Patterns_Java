package design.structural.decorator;

public class ABSDecorator extends AutoAPIDecorator {

    public ABSDecorator(AutoAPI api) {
        super(api);
    }

    public double getPrice(){
        price = api.getPrice();
        return addABS(price);
    }

    private double addABS(double price) {
        System.out.println("******** Price before Adding ABS ====> " + price);
        double newPrice =  price + 60.00;
        System.out.println("******** Price After Adding ABS ====> " + newPrice);
        return newPrice;
    }

    public String getDescription(){
        description = api.getDescription();
        return description + " Added ABS -> ";
    }

}
