package src.main.java.com.sokubastudios.alpha.dialogue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NodeInitialiser {
    private final Map<String, Node> NODE_MAP;

    public NodeInitialiser() {
        NODE_MAP = new HashMap<>();
    }

    public void initialiseNodes() {
        JSONParser parser = new JSONParser();

        try {
            JSONObject file = (JSONObject) parser.parse(new FileReader("src/main/resources/com/sokubastudios/alpha/dialogue/convo.json"));
            JSONArray array = (JSONArray) file.get("nodes");

            for (Object o : array) {
                JSONObject node = (JSONObject) o;

                String id = (String) node.get("id");
                String data = (String) node.get("data");

                NODE_MAP.put(id, new Node(id, data));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        for (String nodeName : NODE_MAP.keySet()) {
            Node node = NODE_MAP.get(nodeName);
            System.out.println(node.getId() + " | " + node.getData());
        }
    }
}
