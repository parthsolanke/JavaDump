package core;

import java.util.HashSet;
import java.util.Set;

public class Menu {
    public static Set<MenuItem> menu = new HashSet<>();

    static {
        menu.add(new MenuItem("burger", Type.NON_VEG, 180));
        menu.add(new MenuItem("pizza", Type.VEG, 300));
        menu.add(new MenuItem("pasta", Type.VEG, 109));
        menu.add(new MenuItem("coffe", Type.BEVRAGE, 90));
    }

    public void addMenueItem(MenuItem item) {
        if(!menu.add(item)) {
            System.out.println("Item alredy exists");
        }
    }

    public static Set<MenuItem> getMenu() {
        return menu;
    }
}