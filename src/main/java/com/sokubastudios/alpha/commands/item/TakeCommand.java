package src.main.java.com.sokubastudios.alpha.commands.item;

import src.main.java.com.sokubastudios.alpha.Character;
import src.main.java.com.sokubastudios.alpha.Item;
import src.main.java.com.sokubastudios.alpha.GameState;
import src.main.java.com.sokubastudios.alpha.commands.Command;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

public class TakeCommand implements Command {
    private final Character CHARACTER;
    private final LocationMap LOCATION_MAP;

    public TakeCommand(Character inCharacter,LocationMap inLocationMap) {
        CHARACTER = inCharacter;
        LOCATION_MAP = inLocationMap;
    }

    @Override
    public boolean use(String argument) {
        if (argument == null) {
            GameState.println("Take what?");
            return false;
        }

        Item item = LOCATION_MAP.getCurrentLocation().getItem(argument);

        if (item == null) {
            GameState.println("You cannot take nothing!");
        } else {
            CHARACTER.addItem(argument, LOCATION_MAP.getCurrentLocation().getItem(argument));
            LOCATION_MAP.getCurrentLocation().removeItem(argument);
            GameState.println("You have taken a " + argument);
        }

        return false;
    }

    @Override
    public String getKey() {
        return "take";
    }

    @Override
    public String getDescription() {
        return "Take an object from a location and add it to the character's inventory.";
    }
}
