package fi.tuni.prog3.json;

/**
 * A class for representing a JSON value. The value can be either a double,
 * a boolean, a String or null.
 */
public class ValueNode extends Node{
    private final Object value;

    /**
     * Constructs a JSON value node that stores the null value.
     */
    public ValueNode() {
        this.value = null;
    }

    /**
     * Constructs a JSON value node that stores the given double value.
     *
     * @param value The double value to store in the new JSON value node.
     */
    public ValueNode(double value) {
        this.value = value;
    }

    /**
     * Constructs a JSON value node that stores the given boolean value.
     *
     * @param value The boolean value to store in the new JSON value node.
     */
    public ValueNode(boolean value) {
        this.value = value;
    }

    /**
     * Constructs a JSON value node that stores the given string.
     *
     * @param value The string to store in the new JSON value node. 
     * @throws IllegalStateException if the parameter value is null.
     */
    public ValueNode(String value) {
        if (value != null) {
            this.value = value;
        } else {
            throw new IllegalStateException("Value is null.");
        }
    }

    /**
     * Checks whether this value node stores a number (double).
     *
     * @return true if this node stores a double value, otherwise false.
     */
    public boolean isNumber() {
        return value instanceof Double;
    }

    /**
     * Checks whether this value node stores a boolean value.
     *
     * @return true if this node stores a boolean value, otherwise false.
     */
    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    /**
     * Checks whether this value node stores a string.
     *
     * @return true if this node stores a string, otherwise false.
     */
    public boolean isString() {
        return value instanceof String;
    }

    /**
     * Checks whether this value node stores null.
     *
     * @return true if this node stores null, otherwise false.
     */
    public boolean isNull() {
        return value == null;
    }

    /**
     * Returns the stored value as a number (double).
     *
     * @return the stored number as a double value.
     * @throws IllegalStateException if the stored value is not a number.
     */
    public double getNumber() {
        if (isNumber()) {
            return (double) value;
        } else {
            throw new IllegalStateException("Value is not a number.");
        }
    }

    /**
     * Returns the stored value as a boolean value.
     *
     * @return the stored boolean value.
     * @throws IllegalStateException if the stored value is not a boolean value.
     */
    public boolean getBoolean() {
        if (isBoolean()) {
            return (boolean) value;
        } else {
            throw new IllegalStateException("Value is not a boolean.");
        }
    }

    /**
     * Returns the stored value as a string.
     *
     * @return the stored string.
     * @throws IllegalStateException if the stored value is not a string.
     */
    public String getString() {
        if (isString()) {
            return (String) value;
        } else {
            throw new IllegalStateException("Value is not a string.");
        }
    }

    /**
     * Returns the stored value as null.
     * @return null.
     * @throws IllegalStateException if the stored value is not null.
     */
    public Object getNull() {
        if (isNull()) {
            return value;
        } else {
            throw new IllegalStateException("Value is not null.");
        }
    }
    
}
