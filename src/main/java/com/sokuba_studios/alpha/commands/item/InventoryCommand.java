package src.main.java.com.sokuba_studios.alpha.commands.item;

import src.main.java.com.sokuba_studios.alpha.Character;
import src.main.java.com.sokuba_studios.alpha.Item;
import src.main.java.com.sokuba_studios.alpha.commands.Command;

import java.util.Map;

public class InventoryCommand implements Command {
    @Override
    public boolean use(String argument) {
        Map<String, Item> ItemList = Character.getItemList();

        for (String item : ItemList.keySet()) {
            System.out.print(item + " ");
        }
        System.out.println();

        return false;
    }

    @Override
    public String getKey() {
        return "inventory";
    }

    @Override
    public String getDescription() {
        return "Open the player inventory and display items.";
    }
}
