package src.main.java.com.sokuba_studios.alpha.locations;

public class Map {
    private static Location[] locations;
    private static Location currentLocation;

    public static void initialiseLocations() {
        Location outside, theatre, pub, lab, office, ise;

        // create rooms
        outside = new Location("outside the main entrance of the university");
        theatre = new Location("in a lecture theatre");
        pub = new Location("in the campus pub");
        lab = new Location("in a computing lab");
        office = new Location("in the computing admin office");
        ise = new Location("in a cool building that is yellow. It is ISE");

        // initialise room exits
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", ise);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        ise.setExit("south", outside);

        currentLocation = outside;
    }

    public static Location getCurrentLocation() {
        return currentLocation;
    }
}
