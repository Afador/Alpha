package src.main.java.com.sokubastudios.alpha;

import src.main.java.com.sokubastudios.alpha.commands.Parser;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

public class AlphaMain {
    private final LocationMap locationMap = new LocationMap();

    public static void main(String[] args) {
        AlphaMain game = new AlphaMain();
        game.play();
    }

    public AlphaMain() {
        locationMap.initialiseLocations();
        Character.setCurrentRoom(locationMap.getCurrentLocation());
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        Parser parser = new Parser(locationMap);
        while (!finished) {
            finished = parser.getCommand();
        }
        System.out.println("Thank you for playing. Goodbye.");

    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Project Alpha");
        System.out.println("© 2025 Sokuba Studios");
        System.out.println();
        System.out.println(locationMap.getCurrentLocation().getName());
        System.out.println(locationMap.getCurrentLocation().getDescription());
    }
}
