package src.main.java.com.sokuba_studios.alpha.commands;

import src.main.java.com.sokuba_studios.alpha.commands.item.DropCommand;
import src.main.java.com.sokuba_studios.alpha.commands.item.InventoryCommand;
import src.main.java.com.sokuba_studios.alpha.commands.item.TakeCommand;
import src.main.java.com.sokuba_studios.alpha.commands.misc.GoCommand;
import src.main.java.com.sokuba_studios.alpha.commands.misc.LookCommand;
import src.main.java.com.sokuba_studios.alpha.commands.misc.QuitCommand;

import java.util.Objects;
import java.util.Scanner;

public class Parser {
    private static final Scanner READER = new Scanner(System.in);
    private static final Command[] COMMANDS = {new DropCommand(), new InventoryCommand(), new TakeCommand(),
                                                new GoCommand(), new LookCommand(), new QuitCommand()};

    private static String key;
    private static String argument;

    public static boolean getCommand() {
        System.out.print(">");
        String inputLine = READER.nextLine().toLowerCase();

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

    public static boolean processCommand() {
        if (key == null) {
            System.out.println("I don't understand your command...");
            return false;
        }

        for (Command command : COMMANDS) {
            if (Objects.equals(command.getKey(), key)) {
                return command.use(argument);
            }
        }

        System.out.println("I do not know what you mean...");
        return false;
    }
}
