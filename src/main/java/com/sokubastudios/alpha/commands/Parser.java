package src.main.java.com.sokubastudios.alpha.commands;

import src.main.java.com.sokubastudios.alpha.Character;
import src.main.java.com.sokubastudios.alpha.commands.item.*;
import src.main.java.com.sokubastudios.alpha.commands.misc.*;
import src.main.java.com.sokubastudios.alpha.dialogue.NodeManager;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

import java.util.Scanner;

public class Parser {
    private final Scanner SCANNER = new Scanner(System.in);
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
        String inputLine = SCANNER.nextLine().toLowerCase();

        key = null;
        argument = null;

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            key = tokenizer.next();

            if (tokenizer.hasNext()) {
                argument = tokenizer.next();
            }
            while (tokenizer.hasNext()) {
                argument = String.join(" ", argument, tokenizer.next());
            }
        }

        return processCommand();
    }

    private boolean processCommand() {
        if (key == null) {
            System.out.println("I don't understand your command...");
            return false;
        }

        Command command = createCommand();
        if (command == null) {
            System.out.println("I do not know what you mean...");
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
