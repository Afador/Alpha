package src.main.java.com.sokubastudios.alpha;

import src.main.java.com.sokubastudios.alpha.commands.Parser;
import src.main.java.com.sokubastudios.alpha.dialogue.NodeInitialiser;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

public class AlphaMain {
    private final Character character;
    private final LocationMap locationMap;
    private final Parser parser;

    public static void main(String[] args) {
        AlphaMain game = new AlphaMain();
        game.play();
    }

    public AlphaMain() {
        character = new Character();
        locationMap = new LocationMap();
        parser = new Parser(character, locationMap);

        locationMap.initialiseLocations();
    }

    public void play() {
        printWelcome();

        NodeInitialiser nodeInitialiser = new NodeInitialiser();

        nodeInitialiser.initialiseNodes();

        boolean finished = false;
        while (!finished) {
            finished = parser.getCommand();
        }
        System.out.println("Game Terminated");
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
