package fi.tuni.prog3.junitattainment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttainmentTest {

    public AttainmentTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        // You can perform setup tasks here that are shared among all test methods.
    }

    @AfterAll
    public static void tearDownClass() {
        // You can perform cleanup tasks here that are shared among all test methods.
    }

    @BeforeEach
    public void setUp() {
        // You can perform setup tasks here that are specific to each test method.
    }

    @AfterEach
    public void tearDown() {
        // You can perform cleanup tasks here that are specific to each test method.
    }

    @Test
    public void testGetCourseCode() {
        Attainment instance = new Attainment("CS100", "151394898", 5);
        String expResult = "CS100";
        String result = instance.getCourseCode();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStudentNumber() {
        Attainment instance = new Attainment("CS100", "151394898", 5);
        String expResult = "151394898";
        String result = instance.getStudentNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGrade() {
        Attainment instance = new Attainment("CS100", "151394898", 5);
        int expResult = 5;
        int result = instance.getGrade();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        Attainment instance = new Attainment("CS100", "151394898", 5);
        String expResult = "CS100 151394898 5";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testCompareTo() {
        Attainment other = new Attainment("CS101", "151394898", 4);
        Attainment instance = new Attainment("CS100", "151394898", 5);
        int expResult = -1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
    }

    @Test
    public void testConstructor() {
        // Test valid constructor
        Attainment instance = new Attainment("CS100", "151394898", 5);

        // Check that values are set correctly
        assertEquals("CS100", instance.getCourseCode());
        assertEquals("151394898", instance.getStudentNumber());
        assertEquals(5, instance.getGrade());
    }

    @Test
    public void testInvalidConstructor() {
        // Test constructor with invalid parameters
        assertThrows(IllegalArgumentException.class, () -> new Attainment("CS100", "151394898", -1));
    }
}