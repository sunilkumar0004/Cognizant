package com.exercise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {
    private final ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testExceptionWithMessage() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            thrower.throwException("Test Message");
        });
        assertEquals("Test Message", exception.getMessage());
    }

    @Test
    public void testExceptionWithEmptyMessage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException("");
        });
        assertEquals("Message cannot be null or empty", exception.getMessage());
    }
}
