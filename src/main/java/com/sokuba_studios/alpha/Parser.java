package src.main.java.com.sokuba_studios.alpha;

import src.main.java.com.sokuba_studios.alpha.commands.Command;
import src.main.java.com.sokuba_studios.alpha.commands.CommandWords;

import java.util.Scanner;

public class Parser {
    private static final CommandWords COMMANDS = new CommandWords();
    private static final Scanner READER = new Scanner(System.in);

    public static Command getCommand() {
        System.out.print("> ");
        String inputLine = READER.nextLine();

        String word1 = null;
        String word2 = null;

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        if (COMMANDS.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2);
        }
    }

    public static void showCommands() {
        COMMANDS.showAll();
    }
}
