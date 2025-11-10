package src.main.java.com.sokuba_studios.alpha.commands.misc;

import src.main.java.com.sokuba_studios.alpha.Character;
import src.main.java.com.sokuba_studios.alpha.Item;
import src.main.java.com.sokuba_studios.alpha.commands.Command;
import src.main.java.com.sokuba_studios.alpha.locations.LocationMap;

import java.util.Map;

public class LookCommand implements Command {
    @Override
    public boolean use(String argument) {
        System.out.println(Character.getCurrentRoom().getDescription());

        Map<String, Item> ItemList = LocationMap.getCurrentLocation().getItemList();
        for (String item : ItemList.keySet()) {
            System.out.print(item + " ");
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
