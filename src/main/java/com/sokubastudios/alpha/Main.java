package src.main.java.com.sokubastudios.alpha;

public class Main {
    public static void main(String[] args) {
        GameState game = new GameState();
        Thread gameThread = new Thread(game::play);
        gameThread.start();

        GameApplication.main(args);
    }
}
