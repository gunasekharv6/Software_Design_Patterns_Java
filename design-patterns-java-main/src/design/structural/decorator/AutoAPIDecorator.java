package design.structural.decorator;

// Abstarct decorator class implementing Auto API by using composition
public abstract class AutoAPIDecorator implements AutoAPI {

    AutoAPI api;

    protected double price;
    protected String description;

    public AutoAPIDecorator(AutoAPI api) {
        this.api = api;
    }

    @Override
    public double getPrice() {
        this.price =  api.getPrice();
        return this.price;
    }

    @Override
    public String getDescription() {
        this.description =  api.getDescription();
        return this.description;
    }
}
