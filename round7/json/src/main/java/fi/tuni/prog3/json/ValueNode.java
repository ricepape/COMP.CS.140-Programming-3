/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.json;

/**
 *
 * @author vudinhthi2304
 */
public class ValueNode extends Node{
    private final Object value;

    // Default constructor initializes the object to null
    public ValueNode() {
        this.value = null;
    }

    // Constructor for double value
    public ValueNode(double value) {
        this.value = value;
    }

    // Constructor for boolean value
    public ValueNode(boolean value) {
        this.value = value;
    }

    // Constructor for string value
    public ValueNode(String value) {
        this.value = value;
    }

    // Check if the stored value is a number
    public boolean isNumber() {
        return value instanceof Double;
    }
    
    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    // Check if the stored value is a string
    public boolean isString() {
        return value instanceof String;
    }

    // Check if the stored value is null
    public boolean isNull() {
        return value == null;
    }

    // Get the stored value as a double
    public double getNumber() {
        if (isNumber()) {
            return (double) value;
        } else {
            throw new IllegalStateException("Value is not a number.");
        }
    }

    // Get the stored value as a boolean
    public boolean getBoolean() {
        if (isBoolean()) {
            return (boolean) value;
        } else {
            throw new IllegalStateException("Value is not a boolean.");
        }
    }

    // Get the stored value as a string
    public String getString() {
        if (isString()) {
            return (String) value;
        } else {
            throw new IllegalStateException("Value is not a string.");
        }
    }

    // Get the stored value as an Object (null)
    public Object getNull() {
        if (isNull()) {
            return value;
        } else {
            throw new IllegalStateException("Value is not null.");
        }
    }

}
