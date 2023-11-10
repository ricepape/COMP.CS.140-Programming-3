package fi.tuni.prog3.junitorder;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Order {
    public static class Entry {
        private Item item;
        private int count;

        public Entry(Item item, int count) throws IllegalArgumentException {
            if (count <= 0) {
                throw new IllegalArgumentException("Item unit count must be positive");
            }
            this.item = item;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        // Method to get the item
        public Item getItem() {
            return item;
        }

        public void removeUnits(int des_count) {
            count -= des_count;
        }

        // Method to create a string representation of the entry
        @Override
        public String toString() {
            return count + " units of " + item.toString();
        }
    }

    public static class Item {
        private final String name;
        private final double unitPrice;

        // Constructor for Item
        public Item(String name, double unitPrice) throws IllegalArgumentException {
            if (name == null || unitPrice < 0) {
                throw new IllegalArgumentException("Invalid input: name cannot be null, and price cannot be negative.");
            }
            this.name = name;
            this.unitPrice = unitPrice;
        }

        // Getter method for name
        public String getName() {
            return name;
        }

        // Getter method for unit price
        public double getUnitPrice() {
            return unitPrice;
        }

        // toString method for Item
        @Override
        public String toString() {
            return name;
        }
    }

    private List<Entry> entries;

    // Constructor
    public Order() {
        this.entries = new ArrayList<>();
    }

    // Method to add items to the order based on Order.Item
    public boolean addItems(Item item, int count) throws IllegalArgumentException {
        if (count <= 0) {
            throw new IllegalArgumentException("Item unit count must be positive");
        }

        Entry entry = new Entry(item, count);
        entries.add(entry);
        return true;
    }

    // Method to add items to the order based on item name
    public boolean addItems(String name, int count) throws IllegalArgumentException, NoSuchElementException {
        // Adds count units of an item to the order based on item name.
        // Note: Implement the logic based on the provided documentation.
        // If needed, handle IllegalArgumentException and NoSuchElementException.
        if (count <= 0) {
            throw new IllegalArgumentException("Item unit count must be positive");
        }

        Item item = new Item(name, 0.0); // You may need to provide a unit price here
        Entry entry = new Entry(item, count);
        entries.add(entry);
        return true;
    }

    // Method to get order entries
    public List<Entry> getEntries() {
        // Returns the order entries in their original adding order.
        // Note: The returned list should be a copy to avoid modifying the internal state.
        return new ArrayList<>(entries);
    }

    // Method to get the total number of item entries in the order
    public int getEntryCount() {
        // Returns the total number of item entries in this order.
        // Note: Implement the logic based on the provided documentation.
        return entries.size();
    }

    // Method to get the total number of entries in the order
    public int getItemCount() {
        // Returns the total number of entries in this order (= sum of all entries' counts).
        // Note: Implement the logic based on the provided documentation.
        int totalCount = 0;
        for (Entry entry : entries) {
            totalCount += entry.getCount();
        }
        return totalCount;
    }

    // Method to get the total price of the order
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Entry entry : entries) {
            totalPrice += entry.getCount() * entry.getItem().getUnitPrice();
        }
        return totalPrice;
    }

    // Method to check if the order is empty
    public boolean isEmpty() {
        // Tells whether the order is empty.
        // Note: Implement the logic based on the provided documentation.
        return entries.isEmpty();
    }

    // Method to remove items from the order
    public boolean removeItems(String name, int count) throws IllegalArgumentException {
        // Removes count units of an item from the order.
        // Note: Implement the logic based on the provided documentation.
        // If needed, handle IllegalArgumentException.
        if (count <= 0) {
            throw new IllegalArgumentException("Item unit count must be positive");
        }

        for (Entry entry : entries) {
            if (entry.getItem().getName().equals(name)) {
                if (entry.getCount() <= count) {
                    entries.remove(entry);
                } else {
                    entry.removeUnits(count);
                }
                return true;
            }
        }
        return false;
    }
}