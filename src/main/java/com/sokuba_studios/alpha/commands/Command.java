package src.main.java.com.sokuba_studios.alpha.commands;

public class Command {
    private static String key;
    private static String argument;

    public static void setCommand(String inKey, String inArgument) {
        key = inKey;
        argument = inArgument;
    }

    public static String getKey() {
        return key;
    }

    public static String getArgument() {
        return argument;
    }

    public static boolean hasSecondWord() {
        return argument != null;
    }
}
