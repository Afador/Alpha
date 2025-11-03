package src.main.java.com.sokuba_studios.alpha.locations;

import java.util.HashMap;

public class Location {
    private final String description;
    private java.util.Map<String, Location> exits; // Map direction to neighboring Room

    public Location(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Location neighbor) {
        exits.put(direction, neighbor);
    }

    public Location getExit(String direction) {
        return exits.get(direction);
    }

    public String getExitString() {
        StringBuilder sb = new StringBuilder();
        for (String direction : exits.keySet()) {
            sb.append(direction).append(" ");
        }
        return sb.toString().trim();
    }

    public String getLongDescription() {
        return "You are " + description + ".\nExits: " + getExitString();
    }
}
