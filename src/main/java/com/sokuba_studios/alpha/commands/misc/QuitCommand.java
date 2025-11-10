package src.main.java.com.sokuba_studios.alpha.commands.misc;

import src.main.java.com.sokuba_studios.alpha.commands.Command;

public class QuitCommand implements Command {
    @Override
    public boolean use(String argument) {
        if (argument != null) {
            System.out.println("Quit what?");
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
