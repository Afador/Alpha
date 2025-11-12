package src.main.java.com.sokubastudios.alpha.locations.house;

import src.main.java.com.sokubastudios.alpha.locations.Location;

import java.util.Map;

import static java.util.Map.entry;

public class EngawaHouseLocation extends Location {
    public EngawaHouseLocation() {
        super();
    }

    public void addExits(EntrywayHouseLocation entryway, LargeTatamiRoomHouseLocation largeTatamiRoom) {
        super.addExits(Map.ofEntries(
                entry(entryway, new String[]{"entryway", "to entryway", "entry", "to entry", "downstairs", "down"}),
                entry(largeTatamiRoom, new String[]{"tatami room", "to tatami room", "tatami", "to tatami"})
        ));
    }

    public String getName() {
        return "Upstairs' Engawa";
    }

    public String getDescription() {
        return """
                Leading into the forest situated on the mountain behind the house.
                You can see a way leading to a large tatami room, and stairs leading down.""";
    }
}
