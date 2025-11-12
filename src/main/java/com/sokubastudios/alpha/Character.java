package src.main.java.com.sokubastudios.alpha;

import src.main.java.com.sokubastudios.alpha.locations.Location;

import java.util.HashMap;
import java.util.Map;

public class Character {
    private static Location currentLocation;
    private static final Map<String, Item> ITEMS = new HashMap<>();

    public static Location getCurrentRoom() {
        return currentLocation;
    }

    public static void setCurrentRoom(Location location) {
        currentLocation = location;
    }

    public static void addItem(String name, Item item) {
        ITEMS.put(name, item);
    }

    public static void removeItem(String name) {
        ITEMS.remove(name);
    }

    public static Map<String, Item> getItemList() {
        return ITEMS;
    }

    public static Item getItem(String name) {
        return ITEMS.get(name);
    }
}
