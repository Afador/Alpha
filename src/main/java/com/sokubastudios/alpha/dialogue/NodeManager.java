package src.main.java.com.sokubastudios.alpha.dialogue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

public class NodeManager {
    private final Map<String, Map<String, Node>> NODE_MAPS;
    private final String[] fileNames = {"convo.json"};

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

                    NODE_MAPS.get(dialogueName).put(id, new Node(id, data));

                    JSONArray optionArray = (JSONArray) node.get("options");
                    for (Object object : optionArray) {
                        JSONObject option = (JSONObject) object;

                        String optionData = (String) option.get("optionData");
                        String nextNode = (String) option.get("nextNode");

                        NODE_MAPS.get(dialogueName).get(id).addOption(optionData, nextNode);
                        System.out.println(NODE_MAPS.get(dialogueName).get(id).getOptions());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("There has been an error reading in the files from the dialogues jsons.");
            System.exit(51);
        }

        for (Map<String, Node> nodeMap : NODE_MAPS.values()) {
            for (Node node : nodeMap.values()) {
                System.out.println(node.getId() + " | " + node.getData());
            }
        }
    }

    public void startNodePath(String dialogueName) {
        Map<String, Node> nodeMap = NODE_MAPS.get(dialogueName);
        Scanner scanner = new Scanner(System.in);

        String currentNodeId = "root";
        Node currentNode = nodeMap.get(currentNodeId);

        while (!Objects.equals(currentNode.getId(), "end")) {
            System.out.println(currentNode.getData());

            String[] optionData = new String[currentNode.getOptions().size()];
            String[] nextNode = new String[currentNode.getOptions().size()];

            int i = 0;
            for (Map<String, String> option : currentNode.getOptions()) {
                optionData[i] = (String) option.keySet().toArray()[0];
                nextNode[i] = option.get(optionData[i]);

                System.out.println((i + 1) + ". " + optionData[i]);
                i++;
            }

            int choice;
            while (true) {
                try {
                    System.out.print("\nWhich one? ");
                    choice = scanner.nextInt();

                    if (0 < choice && choice < optionData.length + 1) {
                        break;
                    } else {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Not within expected parameters, you silly.");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Something went wrong. Try again.");
                    scanner.nextLine();
                }
            }

            currentNode = nodeMap.get(nextNode[choice - 1]);
        }
    }
}
