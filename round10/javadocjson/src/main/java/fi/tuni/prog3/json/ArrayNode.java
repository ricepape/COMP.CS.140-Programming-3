package fi.tuni.prog3.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class for representing a JSON array.
 */
public class ArrayNode extends Node implements Iterable<Node>{
    private final List<Node> nodes;

    // Default constructor initializes an empty array
    public ArrayNode() {
        this.nodes = new ArrayList<>();
    }

    // Add a Node to the end of the array
    public void add(Node node) {
        nodes.add(node);
    }

    // Return the number of stored Node objects
    public int size() {
        return nodes.size();
    }

    // Implement the Iterable interface
    @Override
    public Iterator<Node> iterator() {
        return nodes.iterator();
    }
}
