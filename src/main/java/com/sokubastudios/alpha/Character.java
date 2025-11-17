package src.main.java.com.sokubastudios.alpha;

import java.util.HashMap;
import java.util.Map;

public class Character {
    private final Map<String, Item> ITEMS = new HashMap<>();

    public void addItem(String name, Item item) {
        ITEMS.put(name, item);
    }

    public void removeItem(String name) {
        ITEMS.remove(name);
    }

    public Map<String, Item> getItemList() {
        return ITEMS;
    }

    public Item getItem(String name) {
        return ITEMS.get(name);
    }
}
