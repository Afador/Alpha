package src.main.java.com.sokuba_studios.alpha.commands;

import src.main.java.com.sokuba_studios.alpha.Character;
import src.main.java.com.sokuba_studios.alpha.locations.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {
    private static final Scanner READER = new Scanner(System.in);
    private static final Map<String, String> validCommands = new HashMap<>();

    static {
        validCommands.put("go", "Move to another room");
        validCommands.put("quit", "End the game");
        validCommands.put("help", "Show help");
        validCommands.put("look", "Look around");
        validCommands.put("eat", "Eat something");
        validCommands.put("teleport", "Teleport to another room");
    }

    public static boolean getCommand() {
        System.out.print(">");
        String inputLine = READER.nextLine();

        String token1 = null;
        String token2 = null;

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            token1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                token2 = tokenizer.next();
            }
        }

        Command.setCommand(token1, token2);
        return processCommand();
    }

    public static boolean processCommand() {
        String commandWord = Command.getKey();

        if (commandWord == null) {
            System.out.println("I don't understand your command...");
            return false;
        }

        switch (commandWord) {
            case "help":
                printHelp();
                break;
            case "go":
                goRoom();
                break;
            case "quit":
                if (Command.hasSecondWord()) {
                    System.out.println("Quit what?");
                    return false;
                } else {
                    return true; // signal to quit
                }
            default:
                System.out.println("I don't know what you mean...");
                break;
        }
        return false;
    }

    public static void showCommands() {
        System.out.print("Valid commands are: ");
        for (String command : validCommands.keySet()) {
            System.out.print(command + " ");
        }
        System.out.println();
    }

    private static void printHelp() {
        System.out.println("You are lost. You are alone. You wander around the university.");
        System.out.print("Your command words are: ");
        Parser.showCommands();
    }

    private static void goRoom() {
        if (!Command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = Command.getArgument();

        Location nextLocation = src.main.java.com.sokuba_studios.alpha.Character.getCurrentRoom().getExit(direction);

        if (nextLocation == null) {
            System.out.println("There is no door!");
        } else {
            src.main.java.com.sokuba_studios.alpha.Character.setCurrentRoom(nextLocation);
            System.out.println(Character.getCurrentRoom().getLongDescription());
        }
    }
}
