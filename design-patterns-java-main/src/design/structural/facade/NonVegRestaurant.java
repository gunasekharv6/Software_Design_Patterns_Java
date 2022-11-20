package design.structural.facade;

public class NonVegRestaurant implements Hotel {
    @Override
    public Menus getMenus() {
        return new NonvegMenu();
    }
}
