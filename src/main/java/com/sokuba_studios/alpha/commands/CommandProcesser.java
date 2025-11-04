package src.main.java.com.sokuba_studios.alpha.commands;

import src.main.java.com.sokuba_studios.alpha.Character;
import src.main.java.com.sokuba_studios.alpha.locations.Location;

public class CommandProcesser {
    public static boolean processCommand(Command command) {
        String commandWord = command.getCOMMAND();

        if (commandWord == null) {
            System.out.println("I don't understand your command...");
            return false;
        }

        switch (commandWord) {
            case "help":
                printHelp();
                break;
            case "go":
                goRoom(command);
                break;
            case "quit":
                if (command.hasSecondWord()) {
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

    private static void printHelp() {
        System.out.println("You are lost. You are alone. You wander around the university.");
        System.out.print("Your command words are: ");
        Parser.showCommands();
    }

    private static void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getARGUMENT();

        Location nextLocation = Character.getCurrentRoom().getExit(direction);

        if (nextLocation == null) {
            System.out.println("There is no door!");
        } else {
            Character.setCurrentRoom(nextLocation);
            System.out.println(Character.getCurrentRoom().getLongDescription());
        }
    }
}
