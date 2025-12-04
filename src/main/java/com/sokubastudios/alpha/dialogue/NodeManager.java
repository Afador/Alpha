package src.main.java.com.sokubastudios.alpha.dialogue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import src.main.java.com.sokubastudios.alpha.Character;
import src.main.java.com.sokubastudios.alpha.GameState;
import src.main.java.com.sokubastudios.alpha.Item;
import src.main.java.com.sokubastudios.alpha.locations.LocationMap;
import src.main.java.com.sokubastudios.alpha.npcs.Npc;

import java.io.FileReader;
import java.io.Serializable;
import java.util.*;

public class NodeManager implements Serializable {
    private final Map<String, Map<String, Node<Object>>> NODE_MAPS;
    private final String[] fileNames = {"sickly.json", "saviour.json", "storeLong.json", "storeShort.json"};

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
            System.out.println("ERROR: NM-54");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public boolean startNodePath(String dialogueName, LocationMap locationMap, Character character) {
        Map<String, Node<Object>> nodeMap = NODE_MAPS.get(dialogueName);

        String currentNodeId = "root";
        Node<Object> currentNode = nodeMap.get(currentNodeId);

        while (!Objects.equals(currentNode.getId(), "end")) {
            GameState.println(currentNode.getData());

            String[] optionData = new String[currentNode.getOptions().size()];
            String[] nextNode = new String[currentNode.getOptions().size()];

            switch (currentNode.getId()) {
                case "store":
                    List<Item> items = new ArrayList<>();

                    for (Object object : (JSONArray) currentNode.getOther()) {
                        JSONObject item = (JSONObject) object;

                        items.add(new Item((String) item.get("name")));
                    }

                    if (items.size() < 2) {
                        character.addItem(items.getFirst().getName(), items.getFirst());
                    } else {
                        Item charItem = character.getItem(items.getLast().getName());

                        if (charItem != null) {
                            character.addItem(items.getFirst().getName(), items.getFirst());
                            character.removeItem(items.getLast().getName());
                        } else {
                            GameState.println("Looks like you don't have enough money!");
                        }
                    }
                    break;
                case "switch":
                    for (Npc npc : locationMap.getCurrentLocation().getNpcList().values()) {
                        if (Objects.equals(npc.getDialogueName(), dialogueName)) {
                            npc.setDialogueName((String) currentNode.getOther());
                        }
                    }
                    break;
                case "gameWin":
                    GameState.println("- - - < CONGRATS > - - -");
                    GameState.println("YOU WIN");
                    return true;
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

        return false;
    }
}
