package src.main.java.com.sokuba_studios.alpha.npcs.adventurers;

import src.main.java.com.sokuba_studios.alpha.npcs.NPC;

public class Adventurer extends NPC {
    private char rank;

    public Adventurer(String inName, String inType) {
        super(inName, inType);
        rank = 'F';
    }

    public char getRank() {
        return rank;
    }

    public void setRank(char inRank) {
        rank = inRank;
    }
}
