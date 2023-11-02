/**
 * Provides the classes needed for Programming 3 exercise JSON
 * <p>
 * @author N.N.
 * @since 1.0
 */
package fi.tuni.prog3.json;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Represents a JSON object node that stores key-value pairs in a natural sorted order of keys.
 * <p>
 * @author Thi Vu
 * @since 1.0
 */
public class ObjectNode extends Node implements Iterable<String> {
    private final Map<String, Node> keyValuePairs;

    /**
     * Initializes an empty JSON object.
     */
    public ObjectNode() {
        this.keyValuePairs = new TreeMap<>(); // TreeMap to maintain natural sorted order of keys
    }

    /**
     * Get the Node object corresponding to the specified key.
     *
     * @param key The key to retrieve the associated Node.
     * @return Node associated with the specified key or null if the key is not found.
     */
    public Node get(String key) {
        return keyValuePairs.get(key);
    }

    /**
     * Implement the Iterable interface to iterate over keys in a natural sorted order.
     *
     * @return An iterator over the keys in the JSON object.
     */
    @Override
    public Iterator<String> iterator() {
        return keyValuePairs.keySet().iterator();
    }

    /**
     * Add a key-value pair or update the value if the key already exists.
     *
     * @param key  The key to add or update.
     * @param node The Node to associate with the key.
     */
    public void set(String key, Node node) {
        keyValuePairs.put(key, node);
    }

    /**
     * Returns the number of stored key-value pairs in the JSON object.
     *
     * @return The number of key-value pairs in the JSON object.
     */
    public int size() {
        return keyValuePairs.size();
    }

}

