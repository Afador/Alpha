package src.main.java.com.sokubastudios.alpha.commands.misc;

import src.main.java.com.sokubastudios.alpha.GameState;
import src.main.java.com.sokubastudios.alpha.commands.Command;
import src.main.java.com.sokubastudios.alpha.locations.Location;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

public class GoCommand implements Command {
    private final LocationMap LOCATION_MAP;

    public GoCommand(LocationMap inLocationMap) {
        LOCATION_MAP = inLocationMap;
    }

    @Override
    public boolean use(String argument) {
        if (argument == null) {
            GameState.println("Go where?");
            return false;
        }

        Location nextLocation = LOCATION_MAP.getCurrentLocation().getExit(argument);

        if (nextLocation == null) {
            GameState.println("There is no door!");
        } else {
            LOCATION_MAP.setCurrentLocation(nextLocation);
            LookCommand lookCommand = new LookCommand(LOCATION_MAP);
            lookCommand.use();
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
