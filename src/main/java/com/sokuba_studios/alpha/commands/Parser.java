package src.main.java.com.sokuba_studios.alpha.commands;

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
        System.out.print("> ");
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
        if (isCommand(token1)) {
            return CommandProcesser.processCommand();
        } else {
            return CommandProcesser.processCommand();
        }
    }

    public static boolean isCommand(String commandWord) {
        return validCommands.containsKey(commandWord);
    }

    public static void showCommands() {
        System.out.print("Valid commands are: ");
        for (String command : validCommands.keySet()) {
            System.out.print(command + " ");
        }
        System.out.println();
    }
}
