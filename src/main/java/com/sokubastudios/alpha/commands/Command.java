package src.main.java.com.sokubastudios.alpha.commands;

import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

public interface Command {
    LocationMap locationMap = new LocationMap();

    boolean use(String argument);

    String getKey();

    String getDescription();
}
