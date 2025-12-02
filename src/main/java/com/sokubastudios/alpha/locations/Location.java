package src.main.java.com.sokubastudios.alpha.locations;

import src.main.java.com.sokubastudios.alpha.Item;
import src.main.java.com.sokubastudios.alpha.npcs.Npc;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final String NAME;
    private final String DESCRIPTION;
    private final Map<String, Item> ITEMS;
    private final Map<String, Location> EXITS;
    private final Map<String, Npc> NPCS;

    public Location(String inNAME, String inDESCRIPTION) {
        NAME = inNAME;
        DESCRIPTION = inDESCRIPTION;
        EXITS = new HashMap<>();
        ITEMS = new HashMap<>();
        NPCS = new HashMap<>();
    }

    public String getName() {
        return NAME;
    }

    public String getDescription() {
        return DESCRIPTION;
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

    public final void addExits(Map<Location, String[]> exitMap) {
        for (Location location : exitMap.keySet()) {
            for (String exit : exitMap.get(location)) {
                EXITS.put(exit, location);
            }
        }
    }

    public Location getExit(String direction) {
        return EXITS.get(direction);
    }

    public final void addNpc(Npc npc, String name) {
        NPCS.put(name, npc);
    }

    public Npc getNpc(String npcName) {
        return NPCS.get(npcName);
    }

    public Map<String, Npc> getNpcList() {
        return NPCS;
    }
}
