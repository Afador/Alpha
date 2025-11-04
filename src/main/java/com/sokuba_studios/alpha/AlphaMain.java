package src.main.java.com.sokuba_studios.alpha;

import src.main.java.com.sokuba_studios.alpha.commands.Command;
import src.main.java.com.sokuba_studios.alpha.commands.CommandProcesser;
import src.main.java.com.sokuba_studios.alpha.locations.Map;

public class AlphaMain {

    public static void main(String[] args) {
        AlphaMain game = new AlphaMain();
        game.play();
    }

    public AlphaMain() {
        Map.initialiseLocations();
        Character.setCurrentRoom(Map.getCurrentLocation());
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = Parser.getCommand();
            finished = CommandProcesser.processCommand(command);
        }
        System.out.println("Thank you for playing. Goodbye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("ALPHA");
        System.out.println("© 2025 Sokuba Studios");
        System.out.println();
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(Character.getCurrentRoom().getLongDescription());
    }
}
