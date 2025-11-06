package src.main.java.com.sokuba_studios.alpha.locations;

import src.main.java.com.sokuba_studios.alpha.Item;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private String name;
    private String description;
    private final Map<String, Item> ITEMS;
    private final Map<String, Location> EXITS;

    protected Location(String inName, String inDescription) {
        name = inName;
        description = inDescription;
        EXITS = new HashMap<>();
        ITEMS = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String inName) {
        name = inName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String inDescription) {
        description = inDescription;
    }

    public void addItem(String name, Item item) {
        ITEMS.put(name, item);
    }

    public void removeItem(String name) {
        ITEMS.remove(name);
    }

    public Item getItem(String name) {
        return ITEMS.get(name);
    }

    public Map<String, Item> getItemList() {
        return ITEMS;
    }

    public void addExit(String direction, Location neighbor) {
        EXITS.put(direction, neighbor);
    }

    public Location getExit(String direction) {
        return EXITS.get(direction);
    }

    public Map<String, Location> getExitList() {
        return EXITS;
    }
}
