package src.main.java.com.sokuba_studios.alpha.commands.item;

import src.main.java.com.sokuba_studios.alpha.Character;
import src.main.java.com.sokuba_studios.alpha.Item;
import src.main.java.com.sokuba_studios.alpha.commands.Command;
import src.main.java.com.sokuba_studios.alpha.locations.LocationMap;

public class TakeCommand implements Command {
    @Override
    public boolean use(String argument) {
        if (argument == null) {
            System.out.println("Take what?");
            return false;
        }

        Item item = LocationMap.getCurrentLocation().getItem(argument);

        if (item == null) {
            System.out.println("You cannot take nothing!");
        } else {
            Character.addItem(argument, LocationMap.getCurrentLocation().getItem(argument));
            LocationMap.getCurrentLocation().removeItem(argument);
            System.out.println("You have taken a " + argument);
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
