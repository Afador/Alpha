package src.main.java.com.sokuba_studios.alpha.npcs;

public class NPC {
    private String name;
    private String type;

    public NPC(String inName, String inType) {
        name = inName;
        type = inType;
    }

    public String getName() {
        return name;
    }

    public void setName(String inName) {
        name = inName;
    }

    public String getType() {
        return type;
    }

    public void setType(String inType) {
        type = inType;
    }
}
