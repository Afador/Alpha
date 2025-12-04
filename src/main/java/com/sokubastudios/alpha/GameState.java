package src.main.java.com.sokubastudios.alpha;

import src.main.java.com.sokubastudios.alpha.commands.Parser;
import src.main.java.com.sokubastudios.alpha.commands.misc.LookCommand;
import src.main.java.com.sokubastudios.alpha.dialogue.NodeManager;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;

public class GameState implements Serializable {
    public static ArrayBlockingQueue<String> outputQueue = new ArrayBlockingQueue<>(1);
    public static ArrayBlockingQueue<String> inputQueue = new ArrayBlockingQueue<>(1);

    private final LocationMap LOCATION_MAP;
    private final Parser PARSER;

    public GameState() {
        NodeManager nodeManager = new NodeManager();

        LOCATION_MAP = new LocationMap();
        PARSER = new Parser(new Character(), LOCATION_MAP, nodeManager);

        nodeManager.initialiseNodes();
        LOCATION_MAP.initialiseLocations();
    }

    public static void println() {
        println("");
    }

    public static void println(String string) {
        try {
            outputQueue.put(string + "\n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            finished = PARSER.getCommand();
        }
        GameState.println("Game Terminated");
    }

    private void printWelcome() {
        println();
        println("Project Alpha");
        println("© 2025 Sokuba Studios");
        println();
        LookCommand lookCommand = new LookCommand(LOCATION_MAP);
        lookCommand.use();
    }
}
