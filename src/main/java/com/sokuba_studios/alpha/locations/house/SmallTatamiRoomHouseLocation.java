package src.main.java.com.sokuba_studios.alpha.locations.house;

import src.main.java.com.sokuba_studios.alpha.locations.Location;

import java.util.Map;

import static java.util.Map.entry;

public class SmallTatamiRoomHouseLocation extends Location {
    public SmallTatamiRoomHouseLocation() {
        super();
    }

    public void addExits(LargeTatamiRoomHouseLocation largeTatamiRoom) {
        super.addExits(Map.ofEntries(
                entry(largeTatamiRoom, new String[]{"tatami room", "to tatami room", "tatami", "to tatami"})
        ));
    }

    public String getName() {
        return "Upstairs' Small Tatami Room";
    }

    public String getDescription() {
        return """
                A tatami room with three tatami mats.
                You can go back to the large tatami room.""";
    }
}
