package src.main.java.com.sokubastudios.alpha.commands;

import java.io.Serializable;
import java.util.*;

public class TrieNode implements Serializable {
    private final Map<String, TrieNode> CHILDREN = new TreeMap<>();
    private boolean isEnd = false;

    protected List<String> search(String prefix) {
        return search(prefix, "");
    }

    private List<String> search(String prefix, String curChar) {
        List<String> words = new ArrayList<>();

        List<String> prefixArray = prefix.toLowerCase().chars().mapToObj(Character::toString).toList();
        Iterator<String> iPrefix = prefixArray.iterator();

        String character;
        if (iPrefix.hasNext()) {
            character = iPrefix.next();
            words.addAll(CHILDREN.get((character)).search(prefix.substring(1), character));
            if (!iPrefix.hasNext() & CHILDREN.get(character).isEnd) {
                words.add(character);
            }
        } else {
            for (String child : CHILDREN.keySet()) {
                TrieNode childValue = CHILDREN.get(child);
                if (childValue.isEnd) {
                    words.add(child);
                }
                words.addAll(childValue.search("", child));
            }
        }

        for (int i = 0; i < words.toArray().length; i++) {
            words.set(i, curChar + words.get(i));
        }

        return words;
    }

    protected void insert(String word) {
        List<String> wordArray = word.toLowerCase().chars().mapToObj(Character::toString).toList();
        Iterator<String> iWord = wordArray.iterator();

        if (!iWord.hasNext()) {
            isEnd = true;
            return;
        }

        String character = iWord.next();
        if (!CHILDREN.containsKey(character)) {
            CHILDREN.put(character, new TrieNode());
        }
        CHILDREN.get(character).insert(word.substring(1));
    }

    protected boolean delete(String word) {
        List<String> wordArray = word.toLowerCase().chars().mapToObj(Character::toString).toList();
        Iterator<String> iWord = wordArray.iterator();

        if (!iWord.hasNext() && isEnd) {
            if (CHILDREN.isEmpty()) {
                return true;
            }
            isEnd = false;
        }

        if (!iWord.hasNext()) {
            return false;
        }

        String character = iWord.next();

        if (CHILDREN.containsKey(character)) {
            if (CHILDREN.get(character).delete(word.substring(1))) {
                CHILDREN.remove(character);

                return CHILDREN.isEmpty() && !isEnd;
            } else {
                return false;
            }
        }

        return false;
    }
}
