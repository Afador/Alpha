package src.main.java.com.sokubastudios.alpha.locations;

import src.main.java.com.sokubastudios.alpha.locations.house.*;

public class LocationMap {
    private static Location currentLocation;

    public static void initialiseLocations() {
        BathroomHouseLocation bathroom = new BathroomHouseLocation();
        EngawaHouseLocation engawa = new EngawaHouseLocation();
        EntrywayHouseLocation entryway = new EntrywayHouseLocation();
        KitchenHouseLocation kitchen = new KitchenHouseLocation();
        LargeTatamiRoomHouseLocation largeTatamiRoom = new LargeTatamiRoomHouseLocation();
        SmallTatamiRoomHouseLocation smallTatamiRoom = new SmallTatamiRoomHouseLocation();
        TatamiRoomHouseLocation tatamiRoom = new TatamiRoomHouseLocation();

        bathroom.addExits(kitchen);
        engawa.addExits(entryway, largeTatamiRoom);
        entryway.addExits(engawa, kitchen, tatamiRoom);
        kitchen.addExits(bathroom, entryway, tatamiRoom);
        largeTatamiRoom.addExits(engawa, smallTatamiRoom);
        smallTatamiRoom.addExits(largeTatamiRoom);
        tatamiRoom.addExits(entryway, kitchen);

        setCurrentLocation(entryway);
    }

    public static Location getCurrentLocation() {
        return currentLocation;
    }

    public static void setCurrentLocation(Location inCurrentLocation) {
        currentLocation = inCurrentLocation;
    }
}
