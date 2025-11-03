package src.main.java.com.sokuba_studios.alpha;

import src.main.java.com.sokuba_studios.alpha.locations.Location;

public class Character {
    private String name;
    private Location currentLocation;

    public Character(String name, Location startingLocation) {
        this.name = name;
        this.currentLocation = startingLocation;
    }

    public String getName() {
        return name;
    }

    public Location getCurrentRoom() {
        return currentLocation;
    }

    public void setCurrentRoom(Location location) {
        this.currentLocation = location;
    }
}
