package src.main.java.com.sokubastudios.alpha;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        GameState gameState;

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

    private static Thread getGameThread(GameState gameState) {
        return new Thread(() -> {
            gameState.play();

            try {
                FileOutputStream fos = new FileOutputStream("save.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(gameState);
                GameState.println("Game Saved");
            } catch (Exception e) {
                e.printStackTrace();
                GameState.println("Game Was Unable To Save");
            }
        });
    }
}
