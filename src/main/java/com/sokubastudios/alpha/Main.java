package src.main.java.com.sokubastudios.alpha;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static GameState gameState;

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("save.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            gameState = (GameState) ois.readObject();
            ois.close();
            fis.close();
            GameState.println("Save Loaded");
        } catch (Exception e) {
            GameState.println("Game Could Not Load A Save");
            gameState = new GameState();
        }

        Thread gameThread = getGameThread(gameState);
        gameThread.start();

        GameApplication.main(args);
    }

    public static void startDeathThread() {
        Thread deathThread = getDeathThread();
        deathThread.start();
    }

    private static Thread getGameThread(GameState gameState) {
        return new Thread(() -> {
            gameState.finished = false;
            gameState.play();

            try {
                FileOutputStream fos = new FileOutputStream("save.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(gameState);
                GameState.println("Game Saved");
            } catch (Exception e) {
                System.out.println("ERROR: M-43");
                System.out.println(Arrays.toString(e.getStackTrace()));
                GameState.println("Game Was Unable To Save");
            }
        });
    }

    private static Thread getDeathThread() {
        return new Thread(() -> {
            GameState.println("Grandmother Death Countdown Started");
            GameState.println("You have 1 minute to save your dying grandmother.");
            try {
                Thread.sleep(60_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            GameState.println("YOUR GRANDMOTHER IS DEAD");
            GameState.println("> - - - You Lose - - - <");
            gameState.endGame();
        });
    }
}
