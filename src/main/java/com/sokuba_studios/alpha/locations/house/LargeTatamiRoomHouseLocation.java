package src.main.java.com.sokuba_studios.alpha.locations.house;

import src.main.java.com.sokuba_studios.alpha.locations.Location;

import java.util.Map;

import static java.util.Map.entry;

public class LargeTatamiRoomHouseLocation extends Location {
    public LargeTatamiRoomHouseLocation() {
        super();
    }

    public void addExits(EngawaHouseLocation engawa, SmallTatamiRoomHouseLocation smallTatamiRoom) {
        super.addExits(Map.ofEntries(
                entry(engawa, new String[]{"engawa", "to engawa"}),
                entry(smallTatamiRoom, new String[]{"tatami room", "to tatami room", "tatami", "to tatami"})
        ));
    }

    public String getName() {
        return "Upstairs' Large Tatami Room";
    }

    public String getDescription() {
        return """
                A tatami room with eight tatami mats and a large tokonoma.
                You can see a way leading to the engawa, and a small tatami room.""";
    }
}
