package src.main.java.com.sokubastudios.alpha.commands;

public interface Command {
    boolean use(String argument);

    String getKey();

    String getDescription();
}
