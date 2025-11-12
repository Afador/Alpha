package src.main.java.com.sokuba_studios.alpha.locations.house;

import src.main.java.com.sokuba_studios.alpha.locations.Location;

import java.util.Map;

import static java.util.Map.entry;

public class BathroomHouseLocation extends Location {
    public BathroomHouseLocation() {
        super();
    }

    public void addExits(KitchenHouseLocation kitchen) {
        super.addExits(Map.ofEntries(
                entry(kitchen, new String[]{"kitchen", "to kitchen"})
        ));
    }

    public String getName() {
        return "The House's Bathroom";
    }

    public String getDescription() {
        return """
                It is a bathroom.
                You poo and pee here.
                You can also leave and go to the kitchen.""";
    }
}
