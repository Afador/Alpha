package src.main.java.com.sokubastudios.alpha.commands;

import src.main.java.com.sokubastudios.alpha.Character;
import src.main.java.com.sokubastudios.alpha.Main;
import src.main.java.com.sokubastudios.alpha.commands.item.*;
import src.main.java.com.sokubastudios.alpha.commands.misc.*;
import src.main.java.com.sokubastudios.alpha.dialogue.NodeManager;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private final Character character;
    private final LocationMap locationMap;
    private final NodeManager NODE_MANAGER;

    private String key;
    private String argument;

    public Parser(Character inCharacter, LocationMap inLocationMap, NodeManager inNodeManager) {
        character = inCharacter;
        locationMap = inLocationMap;
        NODE_MANAGER = inNodeManager;
    }

    public boolean getCommand() {
        System.out.print(">");

        key = null;
        argument = null;

        String input = "";
        List<String> tokenList = new ArrayList<>();
        try {
            while (input.isEmpty()) {
                input = Main.inputQueue.take();
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
        Main.println();

        if (key == null) {
            Main.println("I don't understand your command...");
            return false;
        }

        Command command = createCommand();
        if (command == null) {
            Main.println("I do not know what you mean...");
            return false;
        }
        return command.use(argument);
    }

    private Command createCommand() {
        return switch (key) {
            case "drop" -> new DropCommand(character, locationMap);
            case "inventory" -> new InventoryCommand(character);
            case "take" -> new TakeCommand(character, locationMap);
            case "go" -> new GoCommand(locationMap);
            case "look" -> new LookCommand(locationMap);
            case "quit" -> new QuitCommand();
            case "talk" -> new TalkCommand(locationMap, NODE_MANAGER);
            default -> null;
        };
    }
}
