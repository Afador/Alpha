package src.main.java.com.sokubastudios.alpha.commands.misc;

import src.main.java.com.sokubastudios.alpha.Item;
import src.main.java.com.sokubastudios.alpha.Main;
import src.main.java.com.sokubastudios.alpha.commands.Command;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;
import src.main.java.com.sokubastudios.alpha.npcs.Npc;

import java.util.Map;

public class LookCommand implements Command {
    private final LocationMap LOCATION_MAP;

    public LookCommand(LocationMap inLocationMap) {
        LOCATION_MAP = inLocationMap;
    }

    public boolean use() {
        return use(null);
    }

    @Override
    public boolean use(String argument) {
        Main.println(LOCATION_MAP.getCurrentLocation().getName());
        Main.println(LOCATION_MAP.getCurrentLocation().getDescription());

        Map<String, Item> itemList = LOCATION_MAP.getCurrentLocation().getItemList();
        if (!itemList.isEmpty()) {
            Main.println("Items In Room: ");
            for (String item : itemList.keySet()) {
                Main.println("- " + item);
            }
            Main.println();
        }

        Map<String, Npc> npcList = LOCATION_MAP.getCurrentLocation().getNpcList();
        if (!npcList.isEmpty()) {
            Main.println("NPCs In Room: ");
            for (String npc : npcList.keySet()) {
                Main.println("- " + npc);
            }
            Main.println();
        }

        return false;
    }

    @Override
    public String getKey() {
        return "look";
    }

    @Override
    public String getDescription() {
        return "Look around the room/location the character is in.";
    }
}
