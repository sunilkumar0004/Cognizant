package com.exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    private static final StringBuilder executionLog = new StringBuilder();

    @BeforeAll
    public static void setUpSuite() {
        // Reset the log in case the class is run multiple times in the same JVM
        executionLog.setLength(0);
    }

    @Test
    @Order(1)
    public void firstTest() {
        executionLog.append("First;");
        System.out.println("Executing Test Order 1");
        assertEquals("First;", executionLog.toString());
    }

    @Test
    @Order(2)
    public void secondTest() {
        executionLog.append("Second;");
        System.out.println("Executing Test Order 2");
        assertEquals("First;Second;", executionLog.toString());
    }

    @Test
    @Order(3)
    public void thirdTest() {
        executionLog.append("Third;");
        System.out.println("Executing Test Order 3");
        assertEquals("First;Second;Third;", executionLog.toString());
    }
}
