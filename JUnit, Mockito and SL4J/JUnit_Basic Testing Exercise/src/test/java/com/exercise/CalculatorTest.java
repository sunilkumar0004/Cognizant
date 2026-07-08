package com.exercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    // Exercise 4: Test Fixtures - Setup Method
    @Before
    public void setUp() {
        // Arrange: Initialize resources before each test
        calculator = new Calculator();
        System.out.println("Set up: Created a new Calculator instance.");
    }

    // Exercise 4: Test Fixtures - Teardown Method
    @After
    public void tearDown() {
        // Teardown: Clean up resources after each test
        calculator = null;
        System.out.println("Tear down: Cleared Calculator instance.");
    }

    // Exercise 2 & Exercise 4: Basic Testing & AAA (Arrange-Act-Assert) Pattern
    @Test
    public void testBasicOperationsWithAAAPattern() {
        // Arrange: Set up inputs and expected outcomes
        int a = 10;
        int b = 5;
        int expectedAdd = 15;
        int expectedSubtract = 5;

        // Act: Perform the action under test
        int actualAdd = calculator.add(a, b);
        int actualSubtract = calculator.subtract(a, b);

        // Assert: Verify that the result matches expectations
        assertEquals("10 + 5 should be 15", expectedAdd, actualAdd);
        assertEquals("10 - 5 should be 5", expectedSubtract, actualSubtract);
    }

    // Exercise 3: Assertions in JUnit
    @Test
    public void testAssertionsDemo() {
        // Assert equals: verifying matching values
        assertEquals("Assert equals: 2 + 3 should equal 5", 5, calculator.add(2, 3));

        // Assert true: verifying a condition is true
        assertTrue("Assert true: 5 is greater than 3", calculator.add(2, 3) > 3);

        // Assert false: verifying a condition is false
        assertFalse("Assert false: 5 is not less than 3", calculator.add(2, 3) < 3);

        // Assert null: verifying an object reference is null
        String nullString = null;
        assertNull("Assert null: variable should be null", nullString);

        // Assert not null: verifying an object reference is not null
        Object notNullObject = new Object();
        assertNotNull("Assert not null: object should not be null", notNullObject);
    }

    // Exercise 2: Testing edge cases / exceptions
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        // Act: Dividing by zero should throw IllegalArgumentException
        calculator.divide(10, 0);
    }
}
