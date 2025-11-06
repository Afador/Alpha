package src.main.java.com.sokuba_studios.alpha.locations;

import src.main.java.com.sokuba_studios.alpha.Item;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final String description;
    private final Map<String, Location> EXITS; // Map direction to neighboring Room
    private final Map<String, Item> ITEMS;

    public Location(String description) {
        this.description = description;
        EXITS = new HashMap<>();
        ITEMS = new HashMap<>();
    }

    public void setExit(String direction, Location neighbor) {
        EXITS.put(direction, neighbor);
    }

    public Location getExit(String direction) {
        return EXITS.get(direction);
    }

    public void setItem(String name, Item item) {
        ITEMS.put(name, item);
    }

    public Item getItem(String name) {
        return ITEMS.get(name);
    }

    public Map<String, Item> getItemList() {
        return ITEMS;
    }

    public void removeItem(String name) {
        ITEMS.remove(name);
    }

    public String getExitString() {
        StringBuilder sb = new StringBuilder();
        for (String direction : EXITS.keySet()) {
            sb.append(direction).append(" ");
        }
        return sb.toString().trim();
    }

    public String getLongDescription() {
        return "You are " + description + ".\nExits: " + getExitString();
    }
}
