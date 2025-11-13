package src.main.java.com.sokubastudios.alpha;

import src.main.java.com.sokubastudios.alpha.commands.Parser;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;

import java.io.*;

public class AlphaMain implements Serializable {
    private LocationMap locationMap;

    public static void main(String[] args) {
        AlphaMain game = new AlphaMain();
        game.play();
    }

    public AlphaMain() {
        try {
            FileInputStream fis = new FileInputStream("serial.txt");
            System.out.println();
            ObjectInputStream ois = new ObjectInputStream(fis);
            locationMap = (LocationMap) ois.readObject();
        } catch (Exception e) {
            System.out.println("ERROR: AM22");
            locationMap = new LocationMap();
        }

        try {
            FileOutputStream fos = new FileOutputStream("serial.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(locationMap);
        } catch (Exception e) {
            System.out.println("ERROR: AM45");
        }

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
