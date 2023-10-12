/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.json;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author vudinhthi2304
 */
public class ObjectNode extends Node implements Iterable<String> {
    private final Map<String, Node> keyValuePairs;

    // Default constructor initializes an empty JSON object
    public ObjectNode() {
        this.keyValuePairs = new TreeMap<>(); // TreeMap to maintain natural sorted order of keys
    }

    // Get the Node object corresponding to the key
    public Node get(String key) {
        return keyValuePairs.get(key);
    }

    // Add a key-value pair or update the value if the key already exists
    public void set(String key, Node node) {
        keyValuePairs.put(key, node);
    }

    // Return the number of stored key-value pairs
    public int size() {
        return keyValuePairs.size();
    }

    // Implement the Iterable interface to iterate over keys
    @Override
    public Iterator<String> iterator() {
        return keyValuePairs.keySet().iterator();
    }
}

