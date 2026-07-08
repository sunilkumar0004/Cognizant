package com.exercise;

public class ExceptionThrower {
    public void throwException(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        throw new RuntimeException(message);
    }
}
