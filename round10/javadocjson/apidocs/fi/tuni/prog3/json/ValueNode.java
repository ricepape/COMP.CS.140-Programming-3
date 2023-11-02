/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.json;

/**
 * Represents a JSON value node that stores different types of values, such as boolean, double, string, or null.
 * <p>
 * @author Thi Vu
 * @since 1.0
 */
public class ValueNode extends Node{
    private final Object value;

    /**
     * Initializes the ValueNode with a null value.
     */
    public ValueNode() {
        this.value = null;
    }

    /**
     * Initializes the ValueNode with a boolean value.
     *
     * @param value The boolean value to store.
     */
    public ValueNode(boolean value) {
        this.value = value;
    }

    /**
     * Initializes the ValueNode with a double value.
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
     * Get the stored value as a boolean.
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
     * Get the stored value as an Object (null).
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
     * Get the stored value as a double.
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
     * Get the stored value as a string.
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
     * Check if the stored value is a boolean.
     *
     * @return true if the stored value is a boolean, otherwise false.
     */
    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    /**
     * Check if the stored value is null.
     *
     * @return true if the stored value is null, otherwise false.
     */
    public boolean isNull() {
        return value == null;
    }

    /**
     * Check if the stored value is a number.
     *
     * @return true if the stored value is a number, otherwise false.
     */
    public boolean isNumber() {
        return value instanceof Double;
    }

    /**
     * Check if the stored value is a string.
     *
     * @return true if the stored value is a string, otherwise false.
     */
    public boolean isString() {
        return value instanceof String;
    }
}
