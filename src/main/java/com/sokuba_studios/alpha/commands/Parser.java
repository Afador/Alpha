package src.main.java.com.sokuba_studios.alpha.commands;

import src.main.java.com.sokuba_studios.alpha.Character;
import src.main.java.com.sokuba_studios.alpha.locations.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {
    private static final Scanner READER = new Scanner(System.in);
    private static final Map<String, String> COMMANDS = new HashMap<>();

    private static String key;
    private static String argument;

    static {
        COMMANDS.put("go", "Move to another room");
        COMMANDS.put("quit", "End the game");
        COMMANDS.put("help", "Show help");
        COMMANDS.put("look", "Look around");
        COMMANDS.put("eat", "Eat something");
        COMMANDS.put("teleport", "Teleport to another room");
    }

    public static boolean getCommand() {
        System.out.print(">");
        String inputLine = READER.nextLine();

        key = null;
        argument = null;

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            key = tokenizer.next();
            if (tokenizer.hasNext()) {
                argument = tokenizer.next();
            }
        }
        return processCommand();
    }

    public static boolean processCommand() {
        if (key == null) {
            System.out.println("I don't understand your command...");
            return false;
        }

        switch (key) {
            case "help":
                printHelp();
                break;
            case "go":
                goRoom();
                break;
            case "quit":
                if (argument != null) {
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
        for (String command : COMMANDS.keySet()) {
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
        if (argument == null) {
            System.out.println("Go where?");
            return;
        }

        Location nextLocation = Character.getCurrentRoom().getExit(argument);

        if (nextLocation == null) {
            System.out.println("There is no door!");
        } else {
            Character.setCurrentRoom(nextLocation);
            System.out.println(Character.getCurrentRoom().getLongDescription());
        }
    }
}
