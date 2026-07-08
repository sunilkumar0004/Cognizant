package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Alice";
        int loginAttempts = 3;
        String ipAddress = "192.168.1.100";

        // Parameterized logs using SLF4J style placeholders
        logger.info("User '{}' attempted to log in. Attempt number: {}", username, loginAttempts);
        logger.warn("Failed login attempt for user '{}' from IP address: {}", username, ipAddress);

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Logs exception with message and dynamic parameter injection
            logger.error("An error occurred during math operation for user '{}': {}", username, e.getMessage(), e);
        }
    }
}
