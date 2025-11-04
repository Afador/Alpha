package src.main.java.com.sokuba_studios.alpha;

import src.main.java.com.sokuba_studios.alpha.locations.Location;

public class Character {
    private static Location currentLocation;

    public static Location getCurrentRoom() {
        return currentLocation;
    }

    public static void setCurrentRoom(Location location) {
        currentLocation = location;
    }
}
