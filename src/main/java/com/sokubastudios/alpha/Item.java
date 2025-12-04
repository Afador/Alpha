package src.main.java.com.sokubastudios.alpha;

import java.io.Serializable;

public class Item implements Serializable {
    private final String NAME;

    public Item(String inName) {
        NAME = inName;
    }

    public String getName() {
        return NAME;
    }
}
