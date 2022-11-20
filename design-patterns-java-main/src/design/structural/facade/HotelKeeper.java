package design.structural.facade;

// This is the game changer - A facade for Hotel System
public class HotelKeeper {

    // Get Veg Menu
    public VegMenu getVegMenu() {

        Hotel h = new VegRestaurant();
        return (VegMenu) h.getMenus();

    }

    // Get NonVeg Menu
    public NonvegMenu getNonvegMenu() {

        Hotel h = new NonVegRestaurant();
        return (NonvegMenu) h.getMenus();

    }

}
