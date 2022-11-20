package design.structural.decorator;

public class Lamborgini implements AutoAPI{

    @Override
    public double getPrice() {
        return 500.88;
    }

    @Override
    public String getDescription() {
        return "This is Lamborgini ->";
    }
}
