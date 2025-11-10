package src.main.java.com.sokuba_studios.alpha.commands;

public interface Command {
    boolean use(String argument);

    String getKey();

    String getDescription();
}
