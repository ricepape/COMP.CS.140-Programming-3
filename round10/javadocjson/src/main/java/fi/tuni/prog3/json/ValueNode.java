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
     * Constructs a JSON value node that stores the given boolean value.
     *
     * @param value The boolean value to store.
     */
    public ValueNode(boolean value) {
        this.value = value;
    }

    /**
     * Constructs a JSON value node that stores the given double value.
     *
     * @param value The double value to store.
     */
    public ValueNode(double value) {
        this.value = value;
    }

    /**
     * Initializes the ValueNode with a string value.
     *
     * @param value The string value to store.
     */
    public ValueNode(String value) {
        this.value = value;
    }

    /**
     * Returns the stored value as a boolean value.
     *
     * @return The stored boolean value.
     * @throws IllegalStateException if the value is not a boolean.
     */
    public boolean getBoolean() {
        if (isBoolean()) {
            return (boolean) value;
        } else {
            throw new IllegalStateException("Value is not a boolean.");
        }
    }

    /**
     * Returns the stored value as null.
     *
     * @return The stored null value.
     * @throws IllegalStateException if the value is not null.
     */
    public Object getNull() {
        if (isNull()) {
            return value;
        } else {
            throw new IllegalStateException("Value is not null.");
        }
    }

    /**
     * Returns the stored value as a number (double).
     *
     * @return The stored double value.
     * @throws IllegalStateException if the value is not a double.
     */
    public double getNumber() {
        if (isNumber()) {
            return (double) value;
        } else {
            throw new IllegalStateException("Value is not a number.");
        }
    }

    /**
     * Returns the stored value as a string.
     *
     * @return The stored string value.
     * @throws IllegalStateException if the value is not a string.
     */
    public String getString() {
        if (isString()) {
            return (String) value;
        } else {
            throw new IllegalStateException("Value is not a string.");
        }
    }

    /**
     * Checks whether this value node stores a boolean value.
     *
     * @return true if the stored value is a boolean, otherwise false.
     */
    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    /**
     * Checks whether this value node stores null.
     *
     * @return true if the stored value is null, otherwise false.
     */
    public boolean isNull() {
        return value == null;
    }

    /**
     * Checks whether this value node stores a number (double).
     *
     * @return true if the stored value is a number, otherwise false.
     */
    public boolean isNumber() {
        return value instanceof Double;
    }

    /**
     * Checks whether this value node stores a string.
     *
     * @return true if the stored value is a string, otherwise false.
     */
    public boolean isString() {
        return value instanceof String;
    }
}
