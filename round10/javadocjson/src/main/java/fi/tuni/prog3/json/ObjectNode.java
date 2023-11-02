package fi.tuni.prog3.json;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * A class for representing a JSON object.
 */
public class ObjectNode extends Node implements Iterable<String> {
    private final Map<String, Node> keyValuePairs;

    /**
     * Constructs an initially empty JSON object node.
     */
    public ObjectNode() {
        this.keyValuePairs = new TreeMap<>(); // TreeMap to maintain natural sorted order of keys
    }

    /**
     * Returns the JSON node stored under the given name.
     *
     * @param key The key to retrieve the associated Node.
     * @return Node associated with the specified key or null if the key is not found.
     */
    public Node get(String key) {
        return keyValuePairs.get(key);
    }

    /**
     * Returns a String iterator that iterates the names of the name-node pairs
     * stored in this JSON object in natural String order.
     *
     * @return An iterator over the keys in the JSON object.
     */
    @Override
    public Iterator<String> iterator() {
        return keyValuePairs.keySet().iterator();
    }

    /**
     * Stores a name - JSON node pair into this JSON object.
     *
     * @param key  The key to add or update.
     * @param node The Node to associate with the key.
     */
    public void set(String key, Node node) {
        keyValuePairs.put(key, node);
    }

    /**
     * Returns the number of JSON nodes stored under this JSON object.
     *
     * @return The number of key-value pairs in the JSON object.
     */
    public int size() {
        return keyValuePairs.size();
    }

}

