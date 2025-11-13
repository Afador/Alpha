package src.main.java.com.sokubastudios.alpha.commands.misc;

import src.main.java.com.sokubastudios.alpha.commands.Command;
import src.main.java.com.sokubastudios.alpha.locations.Location;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

public class GoCommand implements Command {
    private final LocationMap locationMap;

    public GoCommand(LocationMap inLocatioMap) {
        locationMap = inLocatioMap;
    }

    @Override
    public boolean use(String argument) {
        if (argument == null) {
            System.out.println("Go where?");
            return false;
        }

        Location nextLocation = locationMap.getCurrentLocation().getExit(argument);

        if (nextLocation == null) {
            System.out.println("There is no door!");
        } else {
            locationMap.setCurrentLocation(nextLocation);
            System.out.println(locationMap.getCurrentLocation().getName());
            System.out.println(locationMap.getCurrentLocation().getDescription());
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
