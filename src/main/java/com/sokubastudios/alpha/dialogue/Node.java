package src.main.java.com.sokubastudios.alpha.dialogue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Node<T> implements Serializable {
    private final List<Map<String, String>> OPTIONS;
    private final String ID;
    private final String DATA;
    private final T OTHER;

    public Node(String inId, String inData, T inOther) {
        OPTIONS = new ArrayList<>();

        ID = inId;
        DATA = inData;
        OTHER = inOther;
    }

    public String getId() {
        return ID;
    }

    public String getData() {
        return DATA;
    }

    public T getOther() {
        return OTHER;
    }

    public void addOption(String optionData, String nextNode) {
        OPTIONS.add(Map.of(optionData, nextNode));
    }

    public List<Map<String, String>> getOptions() {
        return OPTIONS;
    }
}
