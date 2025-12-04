package src.main.java.com.sokubastudios.alpha.commands.item;

import src.main.java.com.sokubastudios.alpha.Character;
import src.main.java.com.sokubastudios.alpha.Item;
import src.main.java.com.sokubastudios.alpha.Main;
import src.main.java.com.sokubastudios.alpha.commands.Command;

import java.util.Map;

public class InventoryCommand implements Command {
    private final Character character;

    public InventoryCommand(Character inCharacter) {
        character = inCharacter;
    }

    @Override
    public boolean use(String argument) {
        Map<String, Item> ItemList = character.getItemList();

        for (String item : ItemList.keySet()) {
            Main.println("- " + item);
        }
        Main.println();

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
