package src.main.java.com.sokubastudios.alpha.commands;

import src.main.java.com.sokubastudios.alpha.Character;
import src.main.java.com.sokubastudios.alpha.GameState;
import src.main.java.com.sokubastudios.alpha.commands.item.*;
import src.main.java.com.sokubastudios.alpha.commands.misc.*;
import src.main.java.com.sokubastudios.alpha.dialogue.NodeManager;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser implements Serializable {
    private final Character CHARACTER;
    private final LocationMap LOCATION_MAP;
    private final NodeManager NODE_MANAGER;

    private String key;
    private String argument;

    public Parser(Character inCharacter, LocationMap inLocationMap, NodeManager inNodeManager) {
        CHARACTER = inCharacter;
        LOCATION_MAP = inLocationMap;
        NODE_MANAGER = inNodeManager;
    }

    public boolean getCommand() {
        key = null;
        argument = null;

        String input = "";
        List<String> tokenList = new ArrayList<>();
        try {
            while (input.isEmpty()) {
                input = GameState.inputQueue.take();
            }

            String[] tokens = input.split("\\s+");

            tokenList.addAll(Arrays.asList(tokens));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!tokenList.isEmpty()) {
            key = tokenList.removeFirst();

            if (!tokenList.isEmpty()) {
                argument = tokenList.removeFirst();
            }
            while (!tokenList.isEmpty()) {
                argument = String.join(" ", argument, tokenList.removeFirst());
            }
        }

        return processCommand();
    }

    private boolean processCommand() {
        GameState.println();

        if (key == null) {
            GameState.println("I don't understand your command...");
            return false;
        }

        Command command = createCommand();
        if (command == null) {
            GameState.println("I do not know what you mean...");
            return false;
        }
        return command.use(argument);
    }

    private Command createCommand() {
        return switch (key) {
            case "drop" -> new DropCommand(CHARACTER, LOCATION_MAP);
            case "inventory" -> new InventoryCommand(CHARACTER);
            case "take" -> new TakeCommand(CHARACTER, LOCATION_MAP);
            case "go" -> new GoCommand(LOCATION_MAP);
            case "look" -> new LookCommand(LOCATION_MAP);
            case "quit" -> new QuitCommand();
            case "talk" -> new TalkCommand(LOCATION_MAP, NODE_MANAGER);
            default -> null;
        };
    }
}
