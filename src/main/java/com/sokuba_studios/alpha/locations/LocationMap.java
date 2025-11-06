package src.main.java.com.sokuba_studios.alpha.locations;

public class LocationMap {
    private static Location currentLocation;

    public static void initialiseLocations() {
        // rooms within the primary house
        Location entryway, kitchen, bathroom, tatamiRoom, engawa, largeTatamiRoom, smallTatamiRoom;

        entryway = new Location("Grandmother's Entryway", "The entryway for your grandmother's house.\nIt warmly welcomes you inside.\nYou can see a way leading to the kitchen, a tatami room, and stairs leading up.");
        kitchen = new Location("Kitchen", "The kitchen. It is a kitchen.\nYou can see a way leading to the entryway, a bathroom, and a tatami room.");
        bathroom = new Location("Bathroom", "It is a bathroom.\nYou poo and pee here.\nYou can also leave and go to the kitchen.");
        tatamiRoom = new Location("Tatami Room", "A tatami room with six tatami mats and a small tokonoma.\nYou can see a way leading to the kitchen, and the entryway.");
        engawa = new Location("Engawa", "Leading into the forest situated on the mountain behind the house.\nYou can see a way leading to a large tatami room, and stairs leading down.");
        largeTatamiRoom = new Location("Large Tatami Room", "A tatami room with eight tatami mats and a large tokonoma.\nYou can see a way leading to the engawa, and a small tatami room.");
        smallTatamiRoom = new Location("Small Tatami Room", "A tatami room with three tatami mats.\nYou can go back to the large tatami room.");

        entryway.addExit("kitchen", kitchen);
        entryway.addExit("tatami", tatamiRoom);
        entryway.addExit("upstairs", engawa);

        kitchen.addExit("entryway", entryway);
        kitchen.addExit("bathroom", bathroom);
        kitchen.addExit("tatami", tatamiRoom);

        bathroom.addExit("kitchen", kitchen);

        tatamiRoom.addExit("entryway", entryway);
        tatamiRoom.addExit("kitchen", kitchen);

        engawa.addExit("downstairs", entryway);
        engawa.addExit("tatami", largeTatamiRoom);

        largeTatamiRoom.addExit("engawa", engawa);
        largeTatamiRoom.addExit("tatami", smallTatamiRoom);

        smallTatamiRoom.addExit("tatami", largeTatamiRoom);

        currentLocation = entryway;
    }

    public static Location getCurrentLocation() {
        return currentLocation;
    }

    public static void setCurrentLocation(Location inCurrentLocation) {
        currentLocation = inCurrentLocation;
    }
}
