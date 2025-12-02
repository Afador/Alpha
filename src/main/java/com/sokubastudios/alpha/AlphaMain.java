package src.main.java.com.sokubastudios.alpha;

import src.main.java.com.sokubastudios.alpha.commands.Parser;
import src.main.java.com.sokubastudios.alpha.dialogue.NodeManager;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

public class AlphaMain {
    private final Character CHARACTER;
    private final LocationMap LOCATION_MAP;
    private final Parser PARSER;

    public static void main(String[] args) {
        AlphaMain game = new AlphaMain();
        game.play();
    }

    public AlphaMain() {
        CHARACTER = new Character();
        LOCATION_MAP = new LocationMap();
        NodeManager nodeManager = new NodeManager();
        PARSER = new Parser(CHARACTER, LOCATION_MAP, nodeManager);

        nodeManager.initialiseNodes();
        LOCATION_MAP.initialiseLocations();
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            finished = PARSER.getCommand();
        }
        System.out.println("Game Terminated");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Project Alpha");
        System.out.println("© 2025 Sokuba Studios");
        System.out.println();
        System.out.println(LOCATION_MAP.getCurrentLocation().getName());
        System.out.println(LOCATION_MAP.getCurrentLocation().getDescription());
    }
}
