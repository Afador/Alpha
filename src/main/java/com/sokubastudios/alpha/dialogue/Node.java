package src.main.java.com.sokubastudios.alpha.dialogue;

public class Node {
    private String id;
    private String data;
    private Node[] choices;

    public Node(String inId, String inData) {
        id = inId;
        data = inData;
    }

    public String getId() {
        return id;
    }

    public void setId(String inId) {
        id = inId;
    }

    public String getData() {
        return data;
    }

    public void setData(String inData) {
        data = inData;
    }
}
