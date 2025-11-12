package src.main.java.com.sokuba_studios.alpha;

import src.main.java.com.sokuba_studios.alpha.commands.Parser;
import src.main.java.com.sokuba_studios.alpha.locations.LocationMap;

public class AlphaMain {

    public static void main(String[] args) {
        AlphaMain game = new AlphaMain();
        game.play();
    }

    public AlphaMain() {
        LocationMap.initialiseLocations();
        Character.setCurrentRoom(LocationMap.getCurrentLocation());
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            finished = Parser.getCommand();
        }
        System.out.println("Thank you for playing. Goodbye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Project Alpha");
        System.out.println("© 2025 Sokuba Studios");
        System.out.println();
        System.out.println(LocationMap.getCurrentLocation().getName());
        System.out.println(LocationMap.getCurrentLocation().getDescription());
    }
}
