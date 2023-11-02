package fi.tuni.prog3.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class for representing a JSON array.
 */
public class ArrayNode extends Node implements Iterable<Node>{
    
    private final List<Node> nodes;

    /**
    * Constructs an initially empty JSON array node.
    */
    public ArrayNode() {
        this.nodes = new ArrayList<>();
    }

    /**
    * Returns the number of JSON nodes stored in this JSON array.
    */
    public int size() {
        return nodes.size();
    }

    /**
    * Adds a new JSON node to the end of this JSON array.
    * @param node   The current node to be added.
    */
    public void add(Node node) {
        nodes.add(node);
    }

    /**
    * Returns a Node iterator that iterates the JSON nodes stored in this JSON array.
    */
    @Override
    public Iterator<Node> iterator() {
        return nodes.iterator();
    }
}
