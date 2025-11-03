package src.main.java.com.sokuba_studios.alpha;

import src.main.java.com.sokuba_studios.alpha.locations.Location;

public class Character {
    private Location currentLocation;

    public Character(Location startingLocation) {
        this.currentLocation = startingLocation;
    }

    public Location getCurrentRoom() {
        return currentLocation;
    }

    public void setCurrentRoom(Location location) {
        this.currentLocation = location;
    }
}
