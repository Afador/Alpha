package src.main.java.com.sokuba_studios.alpha.locations;

import src.main.java.com.sokuba_studios.alpha.Item;

public class Map {
    private static Location[] locations;
    private static Location currentLocation;

    public static void initialiseLocations() {
        Location outside, theatre, pub, lab, office, ise;

        // create rooms
        outside = new Location("outside","outside the main entrance of the university");
        theatre = new Location("theatre", "in a lecture theatre");
        pub = new Location("pub", "in the campus pub");
        lab = new Location("lab", "in a computing lab");
        office = new Location("office", "in the computing admin office");
        ise = new Location("ise", "in a cool building that is yellow. It is ISE");

        // initialise room exits
        outside.addExit("east", theatre);
        outside.addExit("south", lab);
        outside.addExit("west", pub);
        outside.addExit("north", ise);

        Item shovel = new Item("It is a shovel");
        outside.addItem("shovel", shovel);

        theatre.addExit("west", outside);

        pub.addExit("east", outside);

        lab.addExit("north", outside);
        lab.addExit("east", office);

        office.addExit("west", lab);

        ise.addExit("south", outside);

        currentLocation = outside;

        locations = new Location[]{outside, theatre, pub, lab, office, ise};
    }

    public static Location getCurrentLocation() {
        return currentLocation;
    }
}
