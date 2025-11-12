package src.main.java.com.sokuba_studios.alpha.locations.house;

import src.main.java.com.sokuba_studios.alpha.locations.Location;

import java.util.Map;

import static java.util.Map.entry;

public class KitchenHouseLocation extends Location{
    public KitchenHouseLocation() {
        super();
    }

    public void addExits(BathroomHouseLocation bathroom, EntrywayHouseLocation entryway, TatamiRoomHouseLocation tatamiRoom) {
        super.addExits(Map.ofEntries(
                entry(bathroom, new String[]{"bathroom", "to bathroom"}),
                entry(entryway, new String[]{"entryway", "to entryway", "entry", "to entry"}),
                entry(tatamiRoom, new String[]{"tatami", "to tatami", "tatami room", "to tatami room"})
        ));
    }

    public String getName() {
        return "Grandmother's Kitchen";
    }

    public String getDescription() {
        return """
                The kitchen.
                It is a kitchen.
                You can see a way leading to the entryway, a bathroom, and a tatami room.""";
    }
}
