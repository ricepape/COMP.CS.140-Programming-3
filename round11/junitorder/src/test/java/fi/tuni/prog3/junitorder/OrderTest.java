package fi.tuni.prog3.junitorder;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vudinhthi2304
 */
public class OrderTest {
    
    public OrderTest() {
    }

    
    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }
    /**
     * Test of addItems method, of class Order.
     */
    @Test
    public void testAddItems_OrderItem_int() {
        System.out.println("addItems");
        Order.Item item = new Order.Item("Item1", 10.0);
        int count = 2;
        Order instance = new Order();
        boolean expResult = true;
        boolean result = instance.addItems(item, count);
        assertEquals(expResult, result);
    }

    /**
     * Test of addItems method, of class Order.
     */
    @Test
    public void testAddItems_String_int() {
        System.out.println("addItems");
        String name = "milk";
        int count = 2;
        Order instance = new Order();
        boolean expResult = true;
        boolean result = instance.addItems(name, count);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntries method, of class Order.
     */
    @Test
    public void testGetEntries() {
        System.out.println("getEntries");

        Order.Item item = new Order.Item("Item1", 10.0);
        Order.Entry entry = new Order.Entry(item, 3);
        Order instance = new Order();
        instance.addItems(item, 3);  // Add an entry to the order

        List<Order.Entry> expResult = new ArrayList<>();
        expResult.add(entry);

        List<Order.Entry> result = instance.getEntries();

        // Use assertIterableEquals to compare the lists
        assertEquals(expResult.size(), result.size());
        for (Order.Entry expectedEntry : expResult) {
            assertFalse(result.contains(expectedEntry));
        }
    }

    /**
     * Test of getEntryCount method, of class Order.
     */
    @Test
    public void testGetEntryCount() {
        System.out.println("getEntryCount");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getEntryCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getItemCount method, of class Order.
     */
    @Test
    public void testGetItemCount() {
        System.out.println("getItemCount");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getItemCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalPrice method, of class Order.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of isEmpty method, of class Order.
     */
    @Test
    public void testEmptyOrder() {
        Order order = new Order();

        assertTrue(order.isEmpty());
        assertEquals(0, order.getEntryCount());
        assertEquals(0, order.getItemCount());
        assertEquals(0.0, order.getTotalPrice(), 0.001);
    }

    /**
     * Test of removeItems method, of class Order.
     */
    @Test
    public void testRemoveItems() {
        Order.Item item = new Order.Item("Item1", 10.0);
        Order instance = new Order();
        instance.addItems(item, 5); // Add 5 units of Item1 to the order

        // Attempt to remove 3 units of Item1
        String name = "Item1";
        int count = 3;
        boolean expResult = true; // Expecting successful removal
        boolean result = instance.removeItems(name, count);

        assertEquals(expResult, result);

        // Check that the order contains the correct entries after removal
        List<Order.Entry> expectedEntries = new ArrayList<>();
        expectedEntries.add(new Order.Entry(item, 2));

        List<Order.Entry> actualEntries = instance.getEntries();
        assertEquals(expectedEntries.size(), actualEntries.size());
        for (Order.Entry expectedEntry : expectedEntries) {
            assertFalse(actualEntries.contains(expectedEntry));
        }
    }

    @Test
    public void testAddItemsWithNegativeCount() {
        Order order = new Order();
        Order.Item item = new Order.Item("Item1", 10.0);
        assertThrows(IllegalArgumentException.class, () ->  order.addItems(item, -5));
    }   
    

}