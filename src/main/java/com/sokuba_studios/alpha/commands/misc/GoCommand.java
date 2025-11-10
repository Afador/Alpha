package src.main.java.com.sokuba_studios.alpha.commands.misc;

import src.main.java.com.sokuba_studios.alpha.commands.Command;
import src.main.java.com.sokuba_studios.alpha.locations.Location;
import src.main.java.com.sokuba_studios.alpha.locations.LocationMap;

public class GoCommand implements Command {
    @Override
    public boolean use(String argument) {
        if (argument == null) {
            System.out.println("Go where?");
            return false;
        }

        Location nextLocation = LocationMap.getCurrentLocation().getExit(argument);

        if (nextLocation == null) {
            System.out.println("There is no door!");
        } else {
            LocationMap.setCurrentLocation(nextLocation);
            System.out.println(LocationMap.getCurrentLocation().getDescription());
        }

        return false;
    }

    @Override
    public String getKey() {
        return "go";
    }

    @Override
    public String getDescription() {
        return "Move to another place or room within the environment.";
    }
}
