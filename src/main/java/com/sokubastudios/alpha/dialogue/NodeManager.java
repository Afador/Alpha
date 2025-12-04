package src.main.java.com.sokubastudios.alpha.dialogue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import src.main.java.com.sokubastudios.alpha.GameState;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;
import src.main.java.com.sokubastudios.alpha.npcs.Npc;

import java.io.FileReader;
import java.io.Serializable;
import java.util.*;

public class NodeManager implements Serializable {
    private final Map<String, Map<String, Node<Object>>> NODE_MAPS;
    private final String[] fileNames = {"convo.json", "cool.json"};

    public NodeManager() {
        NODE_MAPS = new HashMap<>();
    }

    public void initialiseNodes() {
        JSONParser parser = new JSONParser();

        try {
            for (String fileName : fileNames) {
                JSONObject file = (JSONObject) parser.parse(new FileReader("src/main/resources/com/sokubastudios/alpha/dialogue/" + fileName));
                JSONArray array = (JSONArray) file.get("nodes");

                String dialogueName = (String) file.get("name");
                NODE_MAPS.put(dialogueName, new HashMap<>());

                for (Object o : array) {
                    JSONObject node = (JSONObject) o;

                    String id = (String) node.get("id");
                    String data = (String) node.get("data");
                    Object other = node.get("other");

                    NODE_MAPS.get(dialogueName).put(id, new Node<>(id, data, other));

                    JSONArray optionArray = (JSONArray) node.get("options");
                    for (Object object : optionArray) {
                        JSONObject option = (JSONObject) object;

                        String optionData = (String) option.get("optionData");
                        String nextNode = (String) option.get("nextNode");

                        NODE_MAPS.get(dialogueName).get(id).addOption(optionData, nextNode);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: NM-51");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void startNodePath(String dialogueName, LocationMap locationMap) {
        Map<String, Node<Object>> nodeMap = NODE_MAPS.get(dialogueName);

        String currentNodeId = "root";
        Node<Object> currentNode = nodeMap.get(currentNodeId);

        while (!Objects.equals(currentNode.getId(), "end")) {
            GameState.println(currentNode.getData());

            String[] optionData = new String[currentNode.getOptions().size()];
            String[] nextNode = new String[currentNode.getOptions().size()];

            switch (currentNode.getId()) {
                case "shop":
                    break;
                case "sold":
                    break;
                case "switch":
                    for (Npc npc : locationMap.getCurrentLocation().getNpcList().values()) {
                        if (Objects.equals(npc.getDialogueName(), dialogueName)) {
                            npc.setDialogueName((String) currentNode.getOther());
                        }
                    }

                    currentNode = nodeMap.get(currentNode.getOptions().getFirst().get(currentNode.getOptions().getFirst().keySet().toArray()[0]));
                    continue;
            }

            int i = 0;
            for (Map<String, String> option : currentNode.getOptions()) {
                optionData[i] = (String) option.keySet().toArray()[0];
                nextNode[i] = option.get(optionData[i]);

                GameState.println((i + 1) + ". " + optionData[i]);
                i++;
            }

            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(GameState.inputQueue.take());

                    if (0 < choice && choice < optionData.length + 1) {
                        break;
                    } else {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (IndexOutOfBoundsException e) {
                    GameState.println("Not within expected parameters, you silly.");
                } catch (Exception e) {
                    GameState.println("Something went wrong. Try again.");
                }
            }

            currentNode = nodeMap.get(nextNode[choice - 1]);
        }

        GameState.println("Conversation Over");
    }
}
