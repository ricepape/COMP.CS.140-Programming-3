/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author vudinhthi2304
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
