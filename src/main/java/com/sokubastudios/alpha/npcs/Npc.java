package src.main.java.com.sokubastudios.alpha.npcs;

import java.io.Serializable;

public class Npc implements Serializable {
    private final String NAME;

    private String dialogueName;

    public Npc(String inName, String inDialogueName) {
        NAME = inName;

        dialogueName = inDialogueName;
    }

    public String getDialogueName() {
        return dialogueName;
    }

    public void setDialogueName(String inDialogueName) {
        dialogueName = inDialogueName;
    }
}
