package src.main.java.com.sokubastudios.alpha.locations;

import java.util.Map;

import static java.util.Map.entry;

public class LocationMap {
    private Location currentLocation;

    public void initialiseLocations() {
        Location bathroom, engawa, entryway, kitchen, largeTatamiRoom, smallTatamiRoom, tatamiRoom;
        Location mainStreet;

        bathroom = new Location("The House's Bathroom", """
                It is a bathroom.
                You poo and pee here.
                You can also leave and go to the kitchen.""");
        engawa = new Location("Upstairs' Engawa", """
                Leading into the forest situated on the mountain behind the house.
                You can see a way leading to a large tatami room, and stairs leading down.""");
        entryway = new Location("Grandmother's Entryway", """
                The entryway for your grandmother's house.
                It warmly welcomes you inside.
                You can see a way leading to the kitchen, a tatami room, and stairs leading up.
                You are also able to leave and go to the main street.""");
        kitchen = new Location("Grandmother's Kitchen", """
                The kitchen.
                It is a kitchen.
                You can see a way leading to the entryway, a bathroom, and a tatami room.""");
        largeTatamiRoom = new Location("Upstairs' Large Tatami Room", """
                A tatami room with eight tatami mats and a large tokonoma.
                You can see a way leading to the engawa, and a small tatami room.""");
        smallTatamiRoom = new Location("Upstairs' Small Tatami Room", """
                A tatami room with three tatami mats.
                You can go back to the large tatami room.""");
        tatamiRoom = new Location("Downstairs' Tatami Room", """
                A tatami room with six tatami mats and a small tokonoma.
                You can see a way leading to the kitchen, and the entryway.""");

        mainStreet = new Location("Main Street", """
                This is the main street of your grandmother's town.
                Many shops and houses litter the street.
                You can see your grandmother's home, the pharmacy, and a shop.""");


        bathroom.addExits(Map.ofEntries(
                entry(kitchen, new String[]{"kitchen", "to kitchen"})
        ));
        engawa.addExits(Map.ofEntries(
                entry(entryway, new String[]{"entryway", "to entryway", "entry", "to entry", "downstairs", "down"}),
                entry(largeTatamiRoom, new String[]{"tatami room", "to tatami room", "tatami", "to tatami"})
        ));
        entryway.addExits(Map.ofEntries(
                entry(engawa, new String[]{"engawa", "to engawa", "upstairs", "up"}),
                entry(kitchen, new String[]{"kitchen", "to kitchen"}),
                entry(tatamiRoom, new String[]{"tatami", "to tatami", "tatami room", "to tatami room"}),
                entry(mainStreet, new String[]{"main street", "to main street", "street", "to street"})
        ));
        kitchen.addExits(Map.ofEntries(
                entry(bathroom, new String[]{"bathroom", "to bathroom"}),
                entry(entryway, new String[]{"entryway", "to entryway", "entry", "to entry"}),
                entry(tatamiRoom, new String[]{"tatami", "to tatami", "tatami room", "to tatami room"})
        ));
        largeTatamiRoom.addExits(Map.ofEntries(
                entry(engawa, new String[]{"engawa", "to engawa"}),
                entry(smallTatamiRoom, new String[]{"tatami room", "to tatami room", "tatami", "to tatami"})
        ));
        smallTatamiRoom.addExits(Map.ofEntries(
                entry(largeTatamiRoom, new String[]{"tatami room", "to tatami room", "tatami", "to tatami"})
        ));
        tatamiRoom.addExits(Map.ofEntries(
                entry(entryway, new String[]{"entryway", "to entryway", "entry", "to entry"}),
                entry(kitchen, new String[]{"kitchen", "to kitchen"})
        ));

        mainStreet.addExits(Map.ofEntries(
                entry(entryway, new String[]{"home", "house", "to house"})
        ));

        setCurrentLocation(entryway);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location inCurrentLocation) {
        currentLocation = inCurrentLocation;
    }
}
