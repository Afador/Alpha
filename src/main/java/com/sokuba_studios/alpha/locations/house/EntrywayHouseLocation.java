package src.main.java.com.sokuba_studios.alpha.locations.house;

import src.main.java.com.sokuba_studios.alpha.locations.Location;

import java.util.Map;

import static java.util.Map.entry;

public class EntrywayHouseLocation extends Location{
    public EntrywayHouseLocation() {
        super();
    }

    public void addExits(EngawaHouseLocation engawa, KitchenHouseLocation kitchen, TatamiRoomHouseLocation tatamiRoom) {
        super.addExits(Map.ofEntries(
                entry(engawa, new String[]{"engawa", "to engawa", "upstairs", "up"}),
                entry(kitchen, new String[]{"kitchen", "to kitchen"}),
                entry(tatamiRoom, new String[]{"tatami", "to tatami", "tatami room", "to tatami room"})
        ));
    }

    public String getName() {
        return "Grandmother's Entryway";
    }

    public String getDescription() {
        return """
                The entryway for your grandmother's house.
                It warmly welcomes you inside.
                You can see a way leading to the kitchen, a tatami room, and stairs leading up.""";
    }
}
