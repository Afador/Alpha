package src.main.java.com.sokubastudios.alpha.dialogue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Node implements Serializable {
    private final List<Map<String, String>> OPTIONS;
    private final String ID;
    private final String DATA;

    public Node(String inID, String inDATA) {
        OPTIONS = new ArrayList<>();

        ID = inID;
        DATA = inDATA;
    }

    public String getId() {
        return ID;
    }

    public String getData() {
        return DATA;
    }

    public void addOption(String optionData, String nextNode) {
        OPTIONS.add(Map.of(optionData, nextNode));
    }

    public List<Map<String, String>> getOptions() {
        return OPTIONS;
    }
}
