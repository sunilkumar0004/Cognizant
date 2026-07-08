package com.exercise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {
    private final EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, -2, -100})
    public void testIsEvenWithEvenNumbers(int number) {
        assertTrue(checker.isEven(number), () -> number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, -1, -99})
    public void testIsEvenWithOddNumbers(int number) {
        assertFalse(checker.isEven(number), () -> number + " should be odd");
    }
}
