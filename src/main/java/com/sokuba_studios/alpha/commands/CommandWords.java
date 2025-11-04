package src.main.java.com.sokuba_studios.alpha.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandWords {
    private static final Map<String, String> validCommands = new HashMap<>();

    static {
        validCommands.put("go", "Move to another room");
        validCommands.put("quit", "End the game");
        validCommands.put("help", "Show help");
        validCommands.put("look", "Look around");
        validCommands.put("eat", "Eat something");
        validCommands.put("teleport", "Teleport to another room");
    }

    public static boolean isCommand(String commandWord) {
        return validCommands.containsKey(commandWord);
    }

    public static void showAll() {
        System.out.print("Valid commands are: ");
        for (String command : validCommands.keySet()) {
            System.out.print(command + " ");
        }
        System.out.println();
    }
}
