package src.main.java.com.sokubastudios.alpha.commands.item;

import src.main.java.com.sokubastudios.alpha.Character;
import src.main.java.com.sokubastudios.alpha.Item;
import src.main.java.com.sokubastudios.alpha.GameState;
import src.main.java.com.sokubastudios.alpha.commands.Command;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

public class DropCommand implements Command {
    private final Character character;
    private final LocationMap locationMap;

    public DropCommand(Character inCharacter, LocationMap inLocationMap) {
        character = inCharacter;
        locationMap = inLocationMap;
    }

    @Override
    public boolean use(String argument) {
        if (argument == null) {
            GameState.println("Drop what?");
            return false;
        }

        Item item = character.getItem(argument);

        if (item == null) {
            GameState.println("You cannot drop nothing!");
        } else {
            locationMap.getCurrentLocation().addItem(item, argument);
            character.removeItem(argument);
            GameState.println("You have dropped a " + argument);
        }

        return false;
    }

    @Override
    public String getKey() {
        return "drop";
    }

    @Override
    public String getDescription() {
        return "Drop an item from the character's inventory into the current location.";
    }
}
