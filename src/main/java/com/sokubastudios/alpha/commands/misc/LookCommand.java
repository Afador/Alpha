package src.main.java.com.sokubastudios.alpha.commands.misc;

import src.main.java.com.sokubastudios.alpha.Item;
import src.main.java.com.sokubastudios.alpha.commands.Command;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;
import src.main.java.com.sokubastudios.alpha.npcs.Npc;

import java.util.Map;

public class LookCommand implements Command {
    private final LocationMap locationMap;

    public LookCommand(LocationMap inLocationMap) {
        locationMap = inLocationMap;
    }

    @Override
    public boolean use(String argument) {
        System.out.println(locationMap.getCurrentLocation().getName());
        System.out.println(locationMap.getCurrentLocation().getDescription());

        Map<String, Item> itemList = locationMap.getCurrentLocation().getItemList();
        for (String item : itemList.keySet()) {
            System.out.print(item + " ");
        }
        System.out.println();

        Map<String, Npc> npcList = locationMap.getCurrentLocation().getNpcList();
        for (String npc : npcList.keySet()) {
            System.out.print(npc + " ");
        }
        System.out.println();

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
