package src.main.java.com.sokuba_studios.alpha.commands;

public class Command {
    private final String COMMAND;
    private final String ARGUMENT;

    public Command(String firstWord, String secondWord) {
        this.COMMAND = firstWord;
        this.ARGUMENT = secondWord;
    }

    public String getCOMMAND() {
        return COMMAND;
    }

    public String getARGUMENT() {
        return ARGUMENT;
    }

    public boolean hasSecondWord() {
        return ARGUMENT != null;
    }
}
