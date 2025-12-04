package src.main.java.com.sokubastudios.alpha.npcs;

import src.main.java.com.sokubastudios.alpha.Item;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Npc implements Serializable {
    private final Map<String, Item> ITEMS;
    private final String NAME;

    private String dialogueName;

    public Npc(String inNAME, String inDIALOGUE_NAME) {
        ITEMS = new HashMap<>();
        NAME = inNAME;

        dialogueName = inDIALOGUE_NAME;
    }

    public String getName() {
        return NAME;
    }

    public String getDialogueName() {
        return dialogueName;
    }

    public void setDialogueName(String inDialogueName) {
        dialogueName = inDialogueName;
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
