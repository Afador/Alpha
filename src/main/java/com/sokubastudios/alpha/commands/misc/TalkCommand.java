package src.main.java.com.sokubastudios.alpha.commands.misc;

import src.main.java.com.sokubastudios.alpha.GameState;
import src.main.java.com.sokubastudios.alpha.commands.Command;
import src.main.java.com.sokubastudios.alpha.dialogue.NodeManager;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;
import src.main.java.com.sokubastudios.alpha.npcs.Npc;

public class TalkCommand implements Command {
    private final LocationMap LOCATION_MAP;
    private final NodeManager NODE_MANAGER;

    public TalkCommand(LocationMap inLocationMap, NodeManager inNodeManager) {
        LOCATION_MAP = inLocationMap;
        NODE_MANAGER = inNodeManager;
    }

    @Override
    public boolean use(String argument) {
        if (argument == null) {
            GameState.println("Talk with who?");
            return false;
        }

        Npc npc = LOCATION_MAP.getCurrentLocation().getNpc(argument);

        if (npc == null) {
            GameState.println("You cannot talk to nothing!");
        } else {
            GameState.println("Conversation with " + argument + " begins.");
            NODE_MANAGER.startNodePath(npc.getDialogueName());
        }

        return false;
    }

    @Override
    public String getKey() {
        return "talk";
    }

    @Override
    public String getDescription() {
        return "Talk to another character within the same room.";
    }
}
