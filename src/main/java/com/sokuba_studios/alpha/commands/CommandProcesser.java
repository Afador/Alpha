package src.main.java.com.sokuba_studios.alpha.commands;

import src.main.java.com.sokuba_studios.alpha.Character;
import src.main.java.com.sokuba_studios.alpha.locations.Location;

public class CommandProcesser {
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

        Location nextLocation = Character.getCurrentRoom().getExit(direction);

        if (nextLocation == null) {
            System.out.println("There is no door!");
        } else {
            Character.setCurrentRoom(nextLocation);
            System.out.println(Character.getCurrentRoom().getLongDescription());
        }
    }
}
