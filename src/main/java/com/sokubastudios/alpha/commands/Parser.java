package src.main.java.com.sokubastudios.alpha.commands;

import src.main.java.com.sokubastudios.alpha.commands.item.DropCommand;
import src.main.java.com.sokubastudios.alpha.commands.item.InventoryCommand;
import src.main.java.com.sokubastudios.alpha.commands.item.TakeCommand;
import src.main.java.com.sokubastudios.alpha.commands.misc.GoCommand;
import src.main.java.com.sokubastudios.alpha.commands.misc.LookCommand;
import src.main.java.com.sokubastudios.alpha.commands.misc.QuitCommand;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

import java.util.Objects;
import java.util.Scanner;

public class Parser {
    private final Scanner READER = new Scanner(System.in);
    private final Command[] COMMANDS;

    private String key;
    private String argument;

    public Parser(LocationMap locationMap) {
        COMMANDS = new Command[]{new DropCommand(), new InventoryCommand(), new TakeCommand(),
                new GoCommand(locationMap), new LookCommand(), new QuitCommand()};
    }

    public boolean getCommand() {
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

    public boolean processCommand() {
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
