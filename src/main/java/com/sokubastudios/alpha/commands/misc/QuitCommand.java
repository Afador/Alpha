package src.main.java.com.sokubastudios.alpha.commands.misc;

import src.main.java.com.sokubastudios.alpha.GameState;
import src.main.java.com.sokubastudios.alpha.commands.Command;

public class QuitCommand implements Command {
    @Override
    public boolean use(String argument) {
        if (argument != null) {
            GameState.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getKey() {
        return "quit";
    }

    @Override
    public String getDescription() {
        return "Quit the game safely.";
    }
}
