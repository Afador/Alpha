package src.main.java.com.sokubastudios.alpha.npcs;

import src.main.java.com.sokubastudios.alpha.Item;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Npc implements Serializable {
    private final String NAME;
    private final String DIALOGUE_NAME;
    private final Map<String, Item> ITEMS;

    public Npc(String inNAME, String inDIALOGUE_NAME) {
        NAME = inNAME;
        DIALOGUE_NAME = inDIALOGUE_NAME;
        ITEMS = new HashMap<>();
    }

    public String getName() {
        return NAME;
    }

    public String getDialogueName() {
        return DIALOGUE_NAME;
    }

    public void addItem(Item item, String name) {
        ITEMS.put(name, item);
    }

    public void addItems(Map<Item, String> itemMap) {
        for (Item item : itemMap.keySet()) {
            ITEMS.put(itemMap.get(item), item);
        }
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
}
