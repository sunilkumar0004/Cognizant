package com.example.springtest.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "5, 5, 10",
        "-2, 4, 2",
        "0, 0, 0",
        "100, -50, 50"
    })
    public void testAddParameterized(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b), 
            () -> a + " + " + b + " should equal " + expected);
    }
}
