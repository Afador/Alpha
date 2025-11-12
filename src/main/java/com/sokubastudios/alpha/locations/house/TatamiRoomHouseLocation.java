package src.main.java.com.sokubastudios.alpha.locations.house;

import src.main.java.com.sokubastudios.alpha.locations.Location;

import java.util.Map;

import static java.util.Map.entry;

public class TatamiRoomHouseLocation extends Location {
    public TatamiRoomHouseLocation() {
        super();
    }

    public void addExits(EntrywayHouseLocation entryway, KitchenHouseLocation kitchen) {
        super.addExits(Map.ofEntries(
                entry(entryway, new String[]{"entryway", "to entryway", "entry", "to entry"}),
                entry(kitchen, new String[]{"kitchen", "to kitchen"})
        ));
    }

    public String getName() {
        return "Downstairs' Tatami Room";
    }

    public String getDescription() {
        return """
                A tatami room with six tatami mats and a small tokonoma.
                You can see a way leading to the kitchen, and the entryway.""";
    }
}
