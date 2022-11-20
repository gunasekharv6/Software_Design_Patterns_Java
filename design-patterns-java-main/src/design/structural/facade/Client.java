package design.structural.facade;

public class Client {
    public static void main(String[] args) {
        HotelKeeper facade = new HotelKeeper();

        VegMenu v = facade.getVegMenu();
        NonvegMenu nv = facade.getNonvegMenu();

        System.out.println(v);
        System.out.println(nv);
    }
}
