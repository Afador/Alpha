package src.main.java.com.sokuba_studios.alpha.commands.item;

import src.main.java.com.sokuba_studios.alpha.Character;
import src.main.java.com.sokuba_studios.alpha.Item;
import src.main.java.com.sokuba_studios.alpha.commands.Command;
import src.main.java.com.sokuba_studios.alpha.locations.LocationMap;

public class DropCommand implements Command {
    @Override
    public boolean use(String argument) {
        if (argument == null) {
            System.out.println("Drop what?");
            return false;
        }

        Item item = src.main.java.com.sokuba_studios.alpha.Character.getItem(argument);

        if (item == null) {
            System.out.println("You cannot drop nothing!");
        } else {
            LocationMap.getCurrentLocation().addItem(argument, item);
            Character.removeItem(argument);
            System.out.println("You have dropped a " + argument);
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
